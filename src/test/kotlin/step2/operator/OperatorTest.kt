package step2.operator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException

internal class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = ["+,PLUS", "-,MINUS", "*,TIMES", "/,DIVIDE"])
    fun `토큰으로 연산법 찾기`(token: String, expect: Operator) {
        // given

        // when
        val result = Operator.findBy(token)

        // then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `토큰이 올바르지 않은경우 exception 발생`() {
        // given
        val unknownToken = "="

        // when
        // then
        assertThatThrownBy { Operator.findBy(unknownToken) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("$unknownToken 존재하지 않는 연산자")
    }

    @ParameterizedTest
    @CsvSource(value = ["+,9", "-,3", "*,18", "/,2"])
    fun `연산자 토큰 별 계산 테스트`(token: String, expect: Int) {
        // given
        val x = 6
        val y = 3

        // when
        val operator = Operator.findBy(token)
        val result = operator.operate(x, y)

        // then
        assertThat(result).isEqualTo(expect)
    }
}
