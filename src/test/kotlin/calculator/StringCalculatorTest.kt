package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringCalculatorTest {

    @Test
    fun `덧셈`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("1+2")).isEqualTo(3)
    }

    @Test
    fun `뺄셈`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("2-1")).isEqualTo(1)
    }

    @Test
    fun `곱셈`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("2*1")).isEqualTo(2)
    }
}
