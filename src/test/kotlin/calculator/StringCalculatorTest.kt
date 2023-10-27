package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.ArithmeticException
import java.lang.IllegalArgumentException

class StringCalculatorTest {
    @Test
    fun `덧셈`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("1 + 2")).isEqualTo(3)
    }

    @Test
    fun `뺄셈`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("1 - 2")).isEqualTo(-1)
    }

    @Test
    fun `곱셈`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("4 * 2")).isEqualTo(8)
    }

    @Test
    fun `나눗셈`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("4 / 2")).isEqualTo(2)
    }

    @Test
    fun `긴 문자열`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("1 + 2 / 3 + 10")).isEqualTo(11)
    }

    @Test
    fun `긴 문자열2`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("1 + 2 * 3 / 3 * 10")).isEqualTo(30)
    }

    @Test
    fun `띄어쓰기 없는 문자열`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("1+2*4")).isEqualTo(12)
    }

    @Test
    fun `입력 값이 null`() {
        val stringCalculator = StringCalculator()
        assertThrows<IllegalArgumentException> { stringCalculator.calculate(null) }
    }

    @Test
    fun `입력 값이 empty`() {
        val stringCalculator = StringCalculator()
        assertThrows<IllegalArgumentException> { stringCalculator.calculate("") }
    }

    @Test
    fun `입력 값이 잘못된 문자열`() {
        val stringCalculator = StringCalculator()
        assertThrows<IllegalArgumentException> { stringCalculator.calculate("1 + 2 +") }
    }

    @Test
    fun `사칙연산 기호가 아닌 것이 포함됨`() {
        val stringCalculator = StringCalculator()
        assertThrows<IllegalArgumentException> { stringCalculator.calculate("1 + 2 & 10") }
    }

    @Test
    fun `0으로 나눔`() {
        val stringCalculator = StringCalculator()
        assertThrows<ArithmeticException> { stringCalculator.calculate("10/0") }
    }
}
