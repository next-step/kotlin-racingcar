package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `Calculator 가 올바르게 계산을 할 수 있다`() {
        val inputValidator = InputValidator()
        val inputConverter = InputConverter()
        val result = Calculator(inputValidator, inputConverter).calculate("2 / 3 - 5")

        assertThat(result).isEqualTo(2 / 3 - 5)
    }
}
