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

    @Test
    fun `올바른 수식을 입력한 경우`() {
        val input = "2 + 3 * 4 / 2"
        val stringCalculator = StringCalculator()

        assertThat(stringCalculator.calculate(input)).isEqualTo(10)
    }

    @Test
    fun `입력값이 null인 경우`() {
        val input = null
        val stringCalculator = StringCalculator()

        assertThatThrownBy {
            stringCalculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙 연산 기호가 아닌 경우`() {
        val input = "2 ? 3 * 4 / 2"
        val stringCalculator = StringCalculator()

        assertThatThrownBy {
            stringCalculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
