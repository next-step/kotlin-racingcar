package study.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

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
