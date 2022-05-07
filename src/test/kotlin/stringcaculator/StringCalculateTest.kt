package stringcaculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class StringCalculateTest {
    private val calculator = StringCalculator()

    @Test
    fun 덧셈() {
        assertThat(calculator.plus(1, 4)).isEqualTo(5)
        assertThat(calculator.plus(123123, 1020)).isEqualTo(124143)
    }

    @Test
    fun 뺄셈() {
        assertThat(calculator.minus(10, 5)).isEqualTo(5)
        assertThat(calculator.minus(5, 15)).isEqualTo(-10)
        assertThat(calculator.minus(0, 5)).isEqualTo(-5)
    }

    @Test
    fun 곱셈() {
        assertThat(calculator.multiply(5, 15)).isEqualTo(75)
        assertThat(calculator.multiply(-1, 15)).isEqualTo(-15)
        assertThat(calculator.multiply(0, 2)).isEqualTo(0)
    }

    @Test
    fun 나눗셈() {
        assertThat(calculator.divide(10, 5)).isEqualTo(2)
        assertThat(calculator.divide(12, 2)).isEqualTo(6)
        assertThat(calculator.divide(3, 1)).isEqualTo(3)
    }

    @Test
    fun `숫자 체크`() {
        assertThat(calculator.checkIsNumber("3")).isTrue
        assertThat(calculator.checkIsNumber(" ")).isFalse
        assertThat(calculator.checkIsNumber("2a")).isFalse
    }

    @Test
    fun `문자열 계산`() {
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10)
        assertThat(calculator.calculate("3 + 3")).isEqualTo(6)
        assertThatIllegalArgumentException().isThrownBy {
            calculator.calculate("  a")
        }
        assertThatIllegalArgumentException().isThrownBy {
            calculator.calculate("3 + 3 # 4")
        }
        assertThatExceptionOfType(ArithmeticException::class.java).isThrownBy {
            calculator.calculate("3 / 0")
        }
    }
}
