package study.calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(
        "1 + 1,2",
        "100 + 2545 + 2,2647",
        "1 - 1,0",
        "10 - 100,-90",
        "5 - 3 - 1,1",
        "1 * 2,2",
        "100 * 24 * 4,9600",
        "1 / 1,1",
        "100 / 24,4"
    )
    fun `사칙연산`(input: String, output: String) {
        assertEquals(output, StringCalculator.calculate(input))
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException`(input: String?) {
        assertThrows<IllegalArgumentException> {
            StringCalculator.calculate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["k + 1", "2 = 3", "5 _ 1"])
    fun `입력된 기호가 사칙연산 기호가 아닌 경우 IllegalArgumentException`(input: String?) {
        assertThrows<IllegalArgumentException> {
            StringCalculator.calculate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["3 + + 4", "+ 5 - 4", "1 - 5 +"])
    fun `사칙연산 기호의 위치가 부적절한 경우 IllegalArgumentException`(input: String?) {
        assertThrows<IllegalArgumentException> {
            StringCalculator.calculate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [" 3 + 2", " 5  - 2", "2 + 2 "])
    fun `공백의 위치가 부적절한 경우 IllegalArgumentException`(input: String?) {
        assertThrows<IllegalArgumentException> {
            StringCalculator.calculate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 2 2", "5 5"])
    fun `숫자의 위치가 부적절한 경우 IllegalArgumentException`(input: String?) {
        assertThrows<IllegalArgumentException> {
            StringCalculator.calculate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["3 / 0"])
    fun `0으로 나누는 경우 ArithmeticException`(input: String?) {
        assertThrows<ArithmeticException> {
            StringCalculator.calculate(input)
        }
    }
}
