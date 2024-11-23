package racingcar.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `계산할 연산식 입력받고 숫자만 추출`() {
        val cal = Calculator("3 + 5 - 1")
        assertThat(cal.getNumbers()).isEqualTo(listOf(3.0, 5.0, 1.0))
    }

    @Test
    fun `계산할 연산식 입력받고 연산자만 추출`() {
        val cal = Calculator("3 + 5 - 1")
        assertThat(cal.getOperators()).isEqualTo(listOf("+", "-"))
    }

    @Test
    fun `계산기 초기화 후 계산수행 1`() {
        val userInput = "3 + 5 - 1"
        Validator.isValidOperator(userInput)
        val cal = Calculator(userInput)
        assertThat(cal.calculate()).isEqualTo(7.0)
    }

    @Test
    fun `계산기 초기화 후 계산수행 2`() {
        val cal = Calculator("2 * 5 / 2")
        assertThat(cal.calculate()).isEqualTo(5.0)
    }
}
