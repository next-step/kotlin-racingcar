package study.step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `덧셈`() {
        val actual = Calculator.calculate("2 + 3")
        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `뺄셈`() {
        val actual = Calculator.calculate("2 - 3")
        assertThat(actual).isEqualTo(-1)
    }

    @Test
    fun `곱셈`() {
        val actual = Calculator.calculate("2 * 3")
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `나눗셈`() {
        val actual = Calculator.calculate("4 / 2")
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun `입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw`() {
        assertThatThrownBy { Calculator.calculate("") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { Calculator.calculate(null) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        assertThatThrownBy { Calculator.calculate("2 % 3") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙 연산을 모두 포함하는 기능 구현`() {
        val actual = Calculator.calculate("2 + 3 * 4 / 2")
        assertThat(actual).isEqualTo(10)
    }
}
