package calculator

import calculator.Calculator.Companion.calculate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun calculate_add_success() {
        assertThat(calculate("1 + 4")).isEqualTo(5)
    }
}
