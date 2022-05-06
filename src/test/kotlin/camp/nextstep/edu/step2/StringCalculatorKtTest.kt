package camp.nextstep.edu.step2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class StringCalculatorKtTest {

    @DisplayName("더하기 단일 연산 테스트")
    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        "5 + 1, 6",
        "10 + 100, 110",
        "-10 + 1, -9",
        "123 + -23, 100",
        "-10 + 10, 0",
    )
    fun plus(exp: String, expected: String) {
        val calculator = StringCalculator()
        assertEquals(expected.toInt(), calculator.calculate(exp))
    }

    @DisplayName("빼기 단일 연산 테스트")
    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        "5 - 1, 4",
        "10 - 100, -90",
        "-10 - 1, -11",
        "123 - -23, 146",
        "-10 - 10, -20",
    )
    fun minus(exp: String, expected: String) {
        val calculator = StringCalculator()
        assertEquals(expected.toInt(), calculator.calculate(exp))
    }

    @DisplayName("나누기 단일 연산 테스트")
    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        "5 / 1, 5",
        "10 / 100, 0",
        "-10 / 1, -10",
        "123 / -123, -1",
        "10 / 10, 1",
    )
    fun divide(exp: String, expected: String) {
        val calculator = StringCalculator()
        assertEquals(expected.toInt(), calculator.calculate(exp))
    }

    @DisplayName("곱하기 단일 연산 테스트")
    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        "5 * 1, 5",
        "10 * 100, 1000",
        "-10 * 1, -10",
        "123 * 0, 0",
        "-10 * -10, 100",
    )
    fun times(exp: String, expected: String) {
        val calculator = StringCalculator()
        assertEquals(expected.toInt(), calculator.calculate(exp))
    }

    @DisplayName("복합 계산 테스트")
    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        "2 + 3 * 4 / 2, 10",
        "10 - 3 * -4 + 2, -26",
        "-2 + 13 - 4 / 7, 1",
        "2 + 3 * 4 * 0, 0",
        "2 / -2 * -24 / 2, 12",
        "2 + 3 - 455 / 2, -225",
        "2 + 3 + 4120 + 100, 4225",
        "-100 + -10000 - 4 - 2, -10106",
    )
    fun complex(exp: String, expected: String) {
        val calculator = StringCalculator()
        assertEquals(expected.toInt(), calculator.calculate(exp))
    }

    @DisplayName("null, 빈 문자열 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" ", "   ", "\t", "\n"] )
    fun nullOrEmptyExpressions(exp: String?) {
        val calculator = StringCalculator()
        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate(exp)
        }
    }
}
