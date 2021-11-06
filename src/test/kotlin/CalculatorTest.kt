import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.Assertions.assertEquals

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "3 + 5=8",
            "9 + 0 + 1=10"
        ],
        delimiter = '='
    )
    fun `덧셈 테스트`(input: String, actual: String) {
        val expected = Calculator(input).execute()
        assertEquals(expected, actual.toInt())
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "2 * 10=20",
            "9 * 9=81"
        ],
        delimiter = '='
    )
    fun `곱셈 테스트`(input: String, actual: String) {
        val expected = Calculator(input).execute()
        assertEquals(expected, actual.toInt())
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "10 / 2=5",
            "9 / 1=9"
        ],
        delimiter = '='
    )
    fun `나눗셈 테스트`(input: String, actual: String) {
        val expected = Calculator(input).execute()
        assertEquals(expected, actual.toInt())
    }

    @Test
    fun `0으로 나누었을 때 예외 테스트`() {
        Assertions.assertThatThrownBy { Calculator("3 / 0").execute() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력 값이 null 이거나 빈 공백 문자인 경우`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator("").execute()
            Calculator(null).execute()
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator("9 ^ 2 ").execute()
            Calculator("10 @ 2 ").execute()
        }
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "2 + 3 * 4 / 2=10",
            "1 * 2 / 2 - 2=-1",
            "3 * 3 / 3 =3"
        ],
        delimiter = '='
    )
    fun `사칙 연산을 모두 포함하는 경우`(input: String, actual: String) {
        val expected = Calculator(input).execute()
        assertEquals(expected, actual.toInt())
    }
}
