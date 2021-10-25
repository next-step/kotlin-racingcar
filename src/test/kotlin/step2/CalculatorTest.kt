package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `덧셈` () {
        val calculator = Calculator()
        val str = "1 + 2"
        assertThat(calculator.calculate(str)).isEqualTo(3)
    }
}