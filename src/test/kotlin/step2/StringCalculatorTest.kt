package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    @Test
    fun `덧셈`() {
        val input = "1 + 2"
        val stringCalculator = StringCalculator()

        assertThat(stringCalculator.calculate(input)).isEqualTo(3)
    }

    @Test
    fun `뺄셈`() {
        val input = "10 - 2"
        val stringCalculator = StringCalculator()

        assertThat(stringCalculator.calculate(input)).isEqualTo(8)
    }

    @Test
    fun `곱셈`() {
        val input = "5 * 2"
        val stringCalculator = StringCalculator()

        assertThat(stringCalculator.calculate(input)).isEqualTo(10)
    }

    @Test
    fun `나눗셈`() {
        val input = "10 / 2"
        val stringCalculator = StringCalculator()

        assertThat(stringCalculator.calculate(input)).isEqualTo(5)
    }

}
