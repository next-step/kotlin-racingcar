package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class StringCalculatorTest {

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource("1 + 2=3", "100 + 1=101", "-1 + 10=9", delimiter = '=')
    fun `덧셈 테스트`(input: String, expectedResult: Long) {
        // when
        val actualResult = StringCalculator.calculate(input)

        // then
        assertEquals(expectedResult, actualResult)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource("1 - 2=-1", "2 - 2=0", "-1 - 10=-11", delimiter = '=')
    fun `뺄셈 테스트`(input: String, expectedResult: Long) {
        // when
        val actualResult = StringCalculator.calculate(input)

        // then
        assertEquals(expectedResult, actualResult)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource("1 * 2=2", "2 * 2=4", "-1 * 10=-10", delimiter = '=')
    fun `곱셈 테스트`(input: String, expectedResult: Long) {
        // when
        val actualResult = StringCalculator.calculate(input)

        // then
        assertEquals(expectedResult, actualResult)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource("1 / 2=0", "2 / 2=1", "100 / 1=100", "-1 / 10=0", delimiter = '=')
    fun `나눗셈 테스트`(input: String, expectedResult: Long) {
        // when
        val actualResult = StringCalculator.calculate(input)

        // then
        assertEquals(expectedResult, actualResult)
    }
}
