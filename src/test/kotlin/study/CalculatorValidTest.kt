package study

import calculator.StringSplitCountInvalidException
import calculator.ValidCheck
import calculator.operation.Addition
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

class CalculatorValidTest {

    @Test
    fun `문자열 split 배열 개수 유효성 검사`() {
        // given
        val input = "2 + 3 * 4 /"

        // when, then
        Assertions.assertThrows(StringSplitCountInvalidException::class.java) {
            ValidCheck.checkSplitArrayCount(input.split(" "))
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 검사`() {
        // given
        val input = "2 + 3 * 4 % 1"

        // when, then
        assertThatThrownBy { ValidCheck.checkSplitArrayOperator(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("operator")
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `널 또는 빈 문자열 검사`(input: String?) {
        // given, when, then
        assertThatThrownBy { ValidCheck.checkEmptyString(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("null")
            .hasMessageContaining("공백")
    }

    @ParameterizedTest
    @CsvSource(value = ["2, 3, 5", "5, 8, 13"])
    fun addition(a: Int, b: Int, result: Int) {
        // given, when, then
        assertTrue(Addition().operation(a, b) == result)
    }
}
