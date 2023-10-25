package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class CalculatorTest {
    @Test
    fun `입력값이 null이거나 빈 공백문자인 경우 예외를 던진다`() {
        val calculator = Calculator()

        assertThatThrownBy { calculator.calculate(null) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculator.calculate("") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculator.calculate("     ") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `값이 잘 안 들어간 경우 예외를 던진다`() {
        val calculator = Calculator()

        assertThatThrownBy { calculator.calculate("+") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculator.calculate("1 + 2 *") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculator.calculate("1 2 3") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculator.calculate("1 / / 2") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `더하기`() {
        val calculator = Calculator()

        assertThat(calculator.calculate("1 + 2")).isEqualTo(3)
        assertThat(calculator.calculate("4 + 2")).isEqualTo(6)
    }

    @Test
    fun `빼기`() {
        val calculator = Calculator()

        assertThat(calculator.calculate("1 - 2")).isEqualTo(-1)
        assertThat(calculator.calculate("4 - 2")).isEqualTo(2)
    }

    @Test
    fun `곱하기`() {
        val calculator = Calculator()

        assertThat(calculator.calculate("3 * 2")).isEqualTo(6)
        assertThat(calculator.calculate("12 * 4")).isEqualTo(48)
    }

    @Test
    fun `나누기`() {
        val calculator = Calculator()

        assertThat(calculator.calculate("3 / 2")).isEqualTo(1)
        assertThat(calculator.calculate("12 / 4")).isEqualTo(3)
    }

    @Test
    fun `복잡한 식`() {
        val calculator = Calculator()

        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10)
        assertThat(calculator.calculate("2 * 3 * 4 / 2 - 1")).isEqualTo(11)
        assertThat(calculator.calculate("2 + 3 * 4 / 2 - 1")).isEqualTo(9)
    }
}
