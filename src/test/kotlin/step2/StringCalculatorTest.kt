package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun `입력값이 null이거나 빈 공백 문자일 경우 예외 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            StringCalculator.calculate(null)
        }
        assertThatIllegalArgumentException().isThrownBy {
            StringCalculator.calculate("")
        }
        assertThatIllegalArgumentException().isThrownBy {
            StringCalculator.calculate(" ")
        }
    }

    @Test
    fun `사칙 연산이 아닌 기호가 포함되었을 경우 예외 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            StringCalculator.calculate("1 , 2")
        }
    }

    @Test
    fun `수식이 완성되지 않았을 경우 예외 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            StringCalculator.calculate("1 + 2 -")
        }
        assertThatIllegalArgumentException().isThrownBy {
            StringCalculator.calculate("1 +")
        }
    }

    @Test
    fun `정상 동작`() {
        assertThat(StringCalculator.calculate("1")).isEqualTo(1)
        assertThat(StringCalculator.calculate("1 + 2")).isEqualTo(3)
        assertThat(StringCalculator.calculate("1 - 3")).isEqualTo(-2)
        assertThat(StringCalculator.calculate("2 * 3")).isEqualTo(6)
        assertThat(StringCalculator.calculate("4 / 2")).isEqualTo(2)
        assertThat(StringCalculator.calculate("1 + 2 - 3 * 4 / 2")).isEqualTo(0)
    }

    @Test
    fun `수식 앞 뒤로 공백이 붙어도 정상 동작`() {
        assertThat(StringCalculator.calculate(" 1 ")).isEqualTo(1)
        assertThat(StringCalculator.calculate(" 1 + 2 ")).isEqualTo(3)
        assertThat(StringCalculator.calculate(" 1 - 3 ")).isEqualTo(-2)
        assertThat(StringCalculator.calculate(" 2 * 3 ")).isEqualTo(6)
        assertThat(StringCalculator.calculate(" 4 / 2 ")).isEqualTo(2)
        assertThat(StringCalculator.calculate(" 1 + 2 - 3 * 4 / 2 ")).isEqualTo(0)
    }

    @Test
    fun `0으로 나누는 경우 예외 발생`() {
        assertThatExceptionOfType(ArithmeticException::class.java).isThrownBy {
            StringCalculator.calculate("1 / 0")
        }
    }

    @Test
    fun `숫자가 아닌 경우 예외 발생`() {
        assertThatExceptionOfType(NumberFormatException::class.java).isThrownBy {
            StringCalculator.calculate("1 + a")
        }
        assertThatExceptionOfType(NumberFormatException::class.java).isThrownBy {
            StringCalculator.calculate(" a")
        }
    }
}
