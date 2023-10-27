package calculator.unit

import calculator.Calculator
import calculator.Formula
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `사칙연산의 순서는 무시한다`() {
        val result = Calculator.calculate(listOf("1", "+", "2", "*", "3", "-", "4", "/", "5"))
        assertThat(result).isEqualTo(1)
    }
}
