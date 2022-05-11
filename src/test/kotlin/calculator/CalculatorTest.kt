package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {
    @Test
    fun `2 + 3 x 4  ÷ 2 를 입력하면 10이 나온다`() {
        // given
        val input = "2 + 3 * 4  / 2"

        // when
        val result = Calculator(input).calculation()

        // then
        assertThat(result).isEqualTo(10.0)
    }

    @Test
    fun `공백이 포함된 입력 값인 '2    0  +  1   0 ' 이 입력된 경우 30이 나온다`() {
        // given
        val input = "2    0  +  1   0 "

        // when
        val result = Calculator(input).calculation()

        // then
        assertThat(result).isEqualTo(30.0)
    }

    @Test
    fun `Infinity 를 발생시키는 연삭리이 입력된 경우 IllegalArgumentException 에러가 발생한다`() {
        // given
        val input = "10 / 0"

        // then
        assertThatThrownBy {
            Calculator(input).calculation()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessage.CALCULATION_VALUE_IS_INFINITY)
    }

    @ParameterizedTest(name = " {0} 을 계산하면 {1} 값이 나온다")
    @CsvSource(
        value = [
            "1 + 2, 3.0",
            "4 - 3, 1.0",
            "7 * 8, 56.0",
            "10 / 5, 2.0"
        ]
    )
    fun `사칙연산이 정상적으로 수행된다`(arithmeticExpression: String, successValue: Double) {
        // when
        val result = Calculator(arithmeticExpression).calculation()

        // then
        assertThat(result).isEqualTo(successValue)
    }
}
