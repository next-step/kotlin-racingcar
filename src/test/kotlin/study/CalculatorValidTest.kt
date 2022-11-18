package study

import calculator.Calculator
import calculator.StringSplitCountInvalidException
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
        val calculator = Calculator()

        // when, then
        Assertions.assertThrows(StringSplitCountInvalidException::class.java) {
            calculator.checkSplitArrayCount(input.split(" "))
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 검사`() {
        // given
        val input = "2 + 3 * 4 % 1"
        val calculator = Calculator()

        // when, then
        assertThatThrownBy { calculator.calculateOperationList(input.split(" ")) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("operator")
    }

    @Test
    fun `입력 값 숫자(정수)가 아닌 경우 검사`() {
        // given
        val input = "2 + 3.3 * 4 % 1"
        val calculator = Calculator()

        // when, then
        assertThatThrownBy { calculator.calculateNumberList(input.split(" ")) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자")
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `널 또는 빈 문자열 검사`(input: String?) {
        // given
        val calculator = Calculator()

        // when, then
        assertThatThrownBy { calculator.checkEmptyString(input) }
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
