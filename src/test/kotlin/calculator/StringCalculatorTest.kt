package calculator

import calculator.StringCalculator.Companion.calculate
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.lang.NullPointerException

class StringCalculatorTest {
    @Test
    fun `덧셈`() {
        assertThat(calculate("1 + 2")).isEqualTo(3)
    }

    @Test
    fun `뺄셈`() {
        assertThat(calculate("2 - 1")).isEqualTo(1)
    }

    @Test
    fun `곱셈`() {
        assertThat(calculate("2 * 3")).isEqualTo(6)
    }

    @Test
    fun `나눗셈`() {
        assertThat(calculate("4 / 2")).isEqualTo(2)
    }

    @Test
    fun `입력 값이 null 또는 빈 문자열`() {
        assertThatThrownBy { calculate(null) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculate("") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculate(" ") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산이 아닌 경우`() {
        assertThatThrownBy { calculate("4 & 2") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `계산`() {
        assertThat(calculate("4 / 2 + 3 * 2 - 5")).isEqualTo(5)
    }
}
