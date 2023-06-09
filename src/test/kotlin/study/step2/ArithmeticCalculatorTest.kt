package study.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class ArithmeticCalculatorTest {

    @Test
    fun `덧셈`() {
        val actual = ArithmeticCalculator().calculate("1 + 2")
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `뺄셈`() {
        val actual = ArithmeticCalculator().calculate("1 - 2")
        assertThat(actual).isEqualTo(-1)
    }

    @Test
    fun `곱셈`() {
        val actual = ArithmeticCalculator().calculate("1 * 2")
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun `나눗셈`() {
        val actual = ArithmeticCalculator().calculate("10 / 2")
        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `입력값이 null일 경우 IllegalArgumentException`() {
        val assertion = assertThrows(IllegalArgumentException::class.java) {
            ArithmeticCalculator().calculate(null)
        }
        assert(assertion is IllegalArgumentException)
    }

    @Test
    fun `입력값이 빈 공백 문자일 경우 IllegalArgumentException`() {
        val assertion = assertThrows(IllegalArgumentException::class.java) {
            ArithmeticCalculator().calculate("")
        }
        assert(assertion is IllegalArgumentException)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException`() {
        val assertion = assertThrows(IllegalArgumentException::class.java) {
            ArithmeticCalculator().calculate("2 ^ 3")
        }
        assert(assertion is IllegalArgumentException)
    }

    @Test
    fun `사칙 연산을 모두 포함하는 기능 구현`() {
        val actual = ArithmeticCalculator().calculate("2 + 3 * 4 / 2")
        assertThat(actual).isEqualTo(10)
    }
}
