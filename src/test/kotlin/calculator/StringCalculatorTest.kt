package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    @Test
    fun `덧셈`() {
        val input = "2 + 3"
        assertThat(StringCalculator.calculate(input)).isEqualTo(5)
    }

    @Test
    fun `뺄셈`() {
        val input = "2 - 3"
        assertThat(StringCalculator.calculate(input)).isEqualTo(-1)
    }

    @Test
    fun `곱셈`() {
        val input = "3 * 4"
        assertThat(StringCalculator.calculate(input)).isEqualTo(12)
    }

    @Test
    fun `나눗셈`() {
        val input = "4 / 2"
        assertThat(StringCalculator.calculate(input)).isEqualTo(2)
    }

    @Test
    fun `입력 값이 null 인 경우 IllegalArgumentException throw`() {
        val input = null
        assertThatThrownBy {
            StringCalculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력 값이 빈 공백 문자일 경우 IllegalArgumentException throw`() {
        val input = "   "
        assertThatThrownBy {
            StringCalculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙 연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        val input = "2 & 3"
        assertThatThrownBy {
            StringCalculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `올바른 계산식이 아닌 경우 IllegalArgumentException throw`() {
        val input = "2 + 3 * 4 /"
        assertThatThrownBy {
            StringCalculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙 연산을 모두 포함하는 기능 구현`() {
        val input = "2 + 3 * 4 / 2"
        assertThat(StringCalculator.calculate(input)).isEqualTo(10)
    }
}
