package study

import calculator.ValidCheck
import calculator.calculateOperationList
import calculator.operation.Addition
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
        assertThatThrownBy { input.calculateOperationList() }
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
    @MethodSource("provideInputNumbers")
    fun addition(a: Int, b: Int) {
        //given, when, then
        assertTrue(Addition().operation(a, b) == a + b)
    }

    private fun provideInputNumbers(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(2, 3),
            Arguments.of(5, 8),
        )
    }
}