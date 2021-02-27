package study.calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * @author tae-heon.song<taeheon.song></taeheon.song>@linecorp.com>
 * @since 2021. 02. 27.
 */
internal class OperatorTest {
    @Test
    fun findBySymbol() {
        assertThat(Operator.findBySymbol("+")).isEqualTo(Operator.PLUS)
    }

    @Test
    fun `findBySymbol if non-valid symbol`() {
        assertThatThrownBy { Operator.findBySymbol("$") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("\$은 존재하지 않는 연산자입니다.")
    }
}