package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "  ", "\n", "\t", "\r", "\r\n"])
    @NullAndEmptySource
    fun `입력값이 null이거나 빈 공백 문자일 경우 예외 발생`(input: String?) {
        assertThatIllegalArgumentException().isThrownBy {
            StringCalculator.calculate(input)
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
        assertThatIllegalArgumentException().isThrownBy {
            StringCalculator.calculate("1 * - + 2")
        }
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1, 1",
            "1 + 2, 3",
            "1 - 3, -2",
            "2 * 3, 6",
            "4 / 2, 2",
            "1 + 2 - 3 * 4 / 2, 0",
        ]
    )
    fun `정상 동작`(input: String, expected: Int) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            " 1 , 1",
            " 1 + 2 , 3",
            " 1 - 3 , -2",
            " 2 * 3 , 6",
            " 4 / 2 , 2",
            " 1 + 2 - 3 * 4 / 2 , 0",
        ]
    )
    fun `수식 앞 뒤로 공백이 붙어도 정상 동작`(input: String, expected: Int) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expected)
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
