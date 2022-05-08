package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    private val calculator = StringCalculator()

    @Test
    fun 더하기() {
        val result = calculator.plus(1.0, 2.0)

        assertThat(result).isEqualTo(3.0)
    }

    @Test
    fun 곱하기() {
        val result = calculator.multiply(1.0, 2.0)

        assertThat(result).isEqualTo(2.0)
    }

    @Test
    fun 빼기() {
        val result = calculator.minus(1.0, 2.0)

        assertThat(result).isEqualTo(-1.0)
    }

    @Test
    fun 나누기() {
        val result = calculator.divide(1.0, 2.0)

        assertThat(result).isEqualTo(0.5)
    }
}
