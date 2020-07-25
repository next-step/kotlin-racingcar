package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class StringCalculatorTest {
    @Test
    fun `덧셈`() {
        val result = StringCalculator.calculate("1 + 2")
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `뺄셈`() {
        val result = StringCalculator.calculate("2 - 1")
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `곱셈`() {
        val result = StringCalculator.calculate("2 * 3")
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `나눗셈`() {
        val result = StringCalculator.calculate("4 / 2")
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `사칙연산이 아닌 경우`() {
        assertThatThrownBy { StringCalculator.calculate("4 & 2") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `계산`() {
        val result = StringCalculator.calculate("4 / 2 + 3 * 2 - 5")
        assertThat(result).isEqualTo(5)
    }
}
