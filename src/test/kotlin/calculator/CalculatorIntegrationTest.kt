@file:Suppress("NonAsciiCharacters")

package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorIntegrationTest {
    private val calculatorInputValidator = CalculatorInputValidator()
    private val calculatorInputParser = CalculatorInputParser()

    private val sut = Calculator(calculatorInputValidator, calculatorInputParser)

    @Test
    fun `calculate - 문자열 입력값이 주어지면 계산된 값을 반환한다`() {
        val input = "2 + 3 * 4 / 2"

        val result = sut.calculate(input)

        assertThat(result).isEqualTo(10.0)
    }

    @Test
    fun `calculate - 문자열 입력값이 주어지면 계산된 값을 반환한다 - 실수`() {
        val input = "2.5 + 3 * 3 / 2"

        val result = sut.calculate(input)

        assertThat(result).isEqualTo(8.25)
    }

    @Test
    fun `calculate - 입력값으로 숫자 하나만 입력되면 해당 숫자를 반환한다`() {
        val input = "1"

        val result = sut.calculate(input)

        assertThat(result).isEqualTo(1.0)
    }
}
