package stringcalculator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    val stringCalculator = StringCalculator()

    @Test
    fun calculate() {
        val validExpression = listOf("10", "-", "5", "*", "3", "/", "2")
        val result = stringCalculator.calculate(validExpression)
        assertThat(result).isEqualTo(7.5)
    }

    @Test
    fun `should exception divided by zero`() {
        val dividedByZeroExpression = listOf("10", "-", "5", "/", "0")
        assertThatThrownBy { stringCalculator.calculate(dividedByZeroExpression) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Division by zero is not allowed")
    }
}
