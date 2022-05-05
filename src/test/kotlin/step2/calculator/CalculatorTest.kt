package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    private val calculator: Calculator by lazy {
        Calculator(ExpressionParser())
    }

    @Test
    fun `사칙 연산 문자열을 받아 연산을 실행한 뒤, 적절한 결과값을 반환한다`() {
        val calculatorResult1 = calculator.calculate("2 + 3 * 4 / 2")
        assertThat(calculatorResult1).isEqualTo((2.0 + 3.0) * 4.0 / 2.0)

        val calculatorResult2 = calculator.calculate("5 * 10 + 5 / 11")
        assertThat(calculatorResult2).isEqualTo((5.0 * 10.0 + 5.0) / 11.0)

        val calculatorResult3 = calculator.calculate("3 / 11 * 5 / 144")
        assertThat(calculatorResult3).isEqualTo(3.0 / 11.0 * 5.0 / 144.0)

        val calculatorResult4 = calculator.calculate("3 - 11 / 5 - 32")
        assertThat(calculatorResult4).isEqualTo((3.0 - 11.0) / 5.0 - 32.0)
    }
}