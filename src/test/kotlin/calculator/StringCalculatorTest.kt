package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class StringCalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `예외_입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw`(inputString: String) {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            StringCalculator().calculate(inputString)
        }
        assertEquals("Input이 비어있어요. 다시 시도해주세요.", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "1 + 2 -"])
    fun `예외_잘못된 형식의 연산식이 주어지면 IllegalArgumentException throw`(inputString: String) {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            StringCalculator().calculate(inputString)
        }
        assertEquals("잘못된 형식의 Input 입니다.", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 1 & 0", "1 % 2 - 1"])
    fun `예외_잘못된 연산기호인 경우 IllegalArgumentException throw`(inputString: String) {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            StringCalculator().calculate(inputString)
        }
        assertEquals("잘못된 연산자에요.", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 1 - a", "$ * 2 - 1"])
    fun `예외_사칙 숫자가 아닌 경우 IllegalArgumentException throw`(inputString: String) {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            StringCalculator().calculate(inputString)
        }
        assertEquals("숫자가 아니에요.", exception.message)
    }

    @ParameterizedTest
    @CsvSource(value = ["1 + 2, 3", "1 + 2 + 3, 6"])
    fun `성공_덧셈연산`(inputStr: String, expected: Long) {
        val actual = StringCalculator().calculate(inputStr)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @CsvSource(value = ["3 - 2, 1", "1 - 2, -1"])
    fun `성공_뺄셈연산`(inputStr: String, expected: Long) {
        val actual = StringCalculator().calculate(inputStr)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @CsvSource(value = ["1 * 2 * 3, 6", "1 * 0 * -1, 0", "1 * -1, -1"])
    fun `성공_곱셈연산`(inputStr: String, expected: Long) {
        val actual = StringCalculator().calculate(inputStr)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @CsvSource(value = ["4 / 2, 2", "5 / 2, 2", "1 / 2, 0", "2 / -1, -2"])
    fun `성공_나눗셈연산`(inputStr: String, expected: Long) {
        val actual = StringCalculator().calculate(inputStr)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @CsvSource(value = ["1 - 1 + 2, 2", "1 * 7 - 1 / 2, 3"])
    fun `성공_혼합연산`(inputStr: String, expected: Long) {
        val actual = StringCalculator().calculate(inputStr)
        assertEquals(expected, actual)
    }
}

