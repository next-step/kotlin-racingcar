package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun `나눗셈`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("2/2")).isEqualTo(1)
    }

    @Test
    fun `나눗셈 0으로 나누는 경우`() {
        val stringCalculator = StringCalculator()
        assertThrows<IllegalArgumentException> { stringCalculator.calculate("2/0") }
    }

    @Test
    fun `계산을 여러번 하는 경우`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("2/2+1")).isEqualTo(2)
    }

    @Test
    fun `입력값이 공백인 경우`() {
        val stringCalculator = StringCalculator()
        assertThrows<IllegalArgumentException> { stringCalculator.calculate("") }
        assertThrows<IllegalArgumentException> { stringCalculator.calculate(" ") }
        assertThrows<IllegalArgumentException> { stringCalculator.calculate("\n") }
    }
}
