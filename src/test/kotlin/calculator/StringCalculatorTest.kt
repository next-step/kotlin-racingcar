package calculator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource("2 - 3 * 4 / 2=-2", "2 + 3 * 4 / 2=10", "2 - 3 + 4 / 2=1", "2 + 3 * 4 - 2=18", "2 + 3 / 6 * 4 - 2=-2", delimiter = '=')
    fun `사칙연산 종합 테스트`(input: String, expectedResult: Long) {
        // when
        val actualResult = StringCalculator.calculate(input)

        // then
        assertEquals(expectedResult, actualResult)
    }

    @ParameterizedTest(name = "input = [{0}]")
    @MethodSource("blankOrNullStrings")
    fun `입력값 null 또는 빈 공백문자 테스트`(input: String?) {
        // when & then
        assertThatThrownBy {
            StringCalculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest(name = "input = [{0}]")
    @ValueSource(strings = ["1 2 3", "1 & 1", "1 + 2 = 1", "3 @ 1", "3 % 1"])
    fun `사칙연산 기호가 아닌 경우`(input: String) {
        // when & then
        assertThatThrownBy {
            StringCalculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    companion object {
        @JvmStatic
        fun blankOrNullStrings() = listOf(null, "", "   ")
    }
}
