package study

import calculator.ValidCheck
import calculator.operation.Addition
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource


class CalculatorValidTest {

    @Test
    @DisplayName("문자열 split 배열 개수 유효성 검사")
    fun splitValidCount() {
        //given
        val input = "2 + 3 * 4 /"

        // when, then
        assertThatThrownBy { ValidCheck.checkSplitArrayCount(input.split(" ")) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자")
            .hasMessageContaining("연산자")
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 검사")
    fun splitValidOperation() {
        //given
        val input = "2 + 3 * 4 % 1"

        // when, then
        assertThatThrownBy { ValidCheck.checkSplitArrayOperator(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("operator")
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = ["", " ", "    "])
    fun isEmpty_String_Exception(input: String?) {
        //given, when, then
        assertThatThrownBy { ValidCheck.checkEmptyString(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("null")
            .hasMessageContaining("공백")
    }

    @ParameterizedTest
    @CsvSource(value = ["2, 3, 5", "5, 8, 13"])
    fun addition(a: Int, b: Int, result: Int) {
        //given, when, then
        assertTrue(Addition().operation(a, b) == result)
    }

}
