package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `덧셈` () {
        val calculator = Calculator()
        val str = "1 + 2 + 3 + 6"
        assertThat(calculator.calculate(str)).isEqualTo(12)
    }
}