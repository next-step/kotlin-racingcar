package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    @Test
    fun 더하기() {
        val result = StringCalculator.plus(1.0, 2.0)

        assertThat(result).isEqualTo(3.0)
    }

    @Test
    fun 곱하기() {
        val result = StringCalculator.multiply(1.0, 2.0)

        assertThat(result).isEqualTo(2.0)
    }

    @Test
    fun 빼기() {
        val result = StringCalculator.minus(1.0, 2.0)

        assertThat(result).isEqualTo(-1.0)
    }

    @Test
    fun 나누기() {
        val result = StringCalculator.divide(1.0, 2.0)

        assertThat(result).isEqualTo(0.5)
    }
}
