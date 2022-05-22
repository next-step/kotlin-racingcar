package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class StringCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" ", "   ", "\t", "\n"])
    fun `예외_입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw`(inputString: String?) {
        assertThrows(IllegalArgumentException::class.java) {
            StringCalculator().calculate(inputString)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "1 + 2 -"])
    fun `예외_잘못된 형식의 연산식이 주어지면 IllegalArgumentException throw`(inputString: String) {
        assertThrows(IllegalArgumentException::class.java) {
            StringCalculator().calculate(inputString)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 1 & 0", "1 % 2 - 1"])
    fun `예외_잘못된 연산기호인 경우 IllegalArgumentException throw`(inputString: String) {
        assertThrows(IllegalArgumentException::class.java) {
            StringCalculator().calculate(inputString)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 1 - a", "$ * 2 - 1"])
    fun `예외_사칙 숫자가 아닌 경우 IllegalArgumentException throw`(inputString: String) {
        assertThrows(IllegalArgumentException::class.java) {
            StringCalculator().calculate(inputString)
        }
    }

    @ParameterizedTest
    @CsvSource(value = ["1 + 2|3", "1 + 2 + 3|6"], delimiter = '|')
    fun `성공_덧셈연산`(inputStr: String, expected: Long) {
        val actual = StringCalculator().calculate(inputStr)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @CsvSource(value = ["3 - 2|1", "1 - 2|-1"], delimiter = '|')
    fun `성공_뺄셈연산`(inputStr: String, expected: Long) {
        val actual = StringCalculator().calculate(inputStr)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @CsvSource(value = ["1 * 2 * 3|6", "1 * 0 * -1|0", "1 * -1|-1"], delimiter = '|')
    fun `성공_곱셈연산`(inputStr: String, expected: Long) {
        val actual = StringCalculator().calculate(inputStr)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @CsvSource(value = ["4 / 2|2", "5 / 2|2", "1 / 2|0", "2 / -1|-2"], delimiter = '|')
    fun `성공_나눗셈연산`(inputStr: String, expected: Long) {
        val actual = StringCalculator().calculate(inputStr)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @CsvSource(value = ["1 - 1 + 2|2", "1 * 7 - 1 / 2|3"], delimiter = '|')
    fun `성공_혼합연산`(inputStr: String, expected: Long) {
        val actual = StringCalculator().calculate(inputStr)
        assertEquals(expected, actual)
    }
}

