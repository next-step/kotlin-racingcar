package stringCalculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import stringCalculator.Message.Companion.INPUT_CONTAINS_CHARACTER
import stringCalculator.Message.Companion.INPUT_CONTAINS_OPERATOR_IN_A_ROW
import stringCalculator.Message.Companion.INPUT_NOT_END_WITH_NUMBER
import stringCalculator.Message.Companion.INPUT_NOT_START_WITH_NUMBER
import stringCalculator.Message.Companion.INPUT_NULL_OR_BLANK
import stringCalculator.Message.Companion.INVALID_OPERATOR

internal class ValidatorTest {

    val validator = Validator()

    @ParameterizedTest
    @MethodSource("correctTestcase")
    fun `입력값이 정상적인 수식일 경우 validate 결과는 true 이다`(input: String, expected: Boolean) {
        val result = validator.isValidInput(input)
        Assertions.assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `blank string을 입력하면 IllegalArgumentException 와 메시지를 출력한다`() {
        assertThatThrownBy { validator.isValidInput(" ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INPUT_NULL_OR_BLANK)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `비어있는(blank) 값을 입력하면 IllegalArgumentException 와 메시지를 출력한다`(input: String?) {
        assertThatThrownBy { validator.isValidInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INPUT_NULL_OR_BLANK)
    }

    @ParameterizedTest
    @MethodSource("edgeTestcase")
    fun `유효하지 않은 입력값이 들어 갈 경우 IllegalArgumentException 와 메시지를 출력한다`(
        input: String,
        errorMessage: String
    ) {
        assertThatThrownBy { validator.isValidInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(errorMessage)
    }

    companion object {
        @JvmStatic
        private fun correctTestcase() = listOf(
            Arguments.of("1 - 2 + 3", true),
            Arguments.of("3 * 3 / 3", true),
        )

        @JvmStatic
        private fun edgeTestcase() = listOf(
            Arguments.of("1 = 2", INVALID_OPERATOR),
            Arguments.of("+ 2 * 3", INPUT_NOT_START_WITH_NUMBER),
            Arguments.of("1 + 2 *", INPUT_NOT_END_WITH_NUMBER),
            Arguments.of("1 + 2 *", INPUT_CONTAINS_CHARACTER),
            Arguments.of("1 + 2 *", INPUT_CONTAINS_CHARACTER),
            Arguments.of("12 + / 20 + 3", INPUT_CONTAINS_OPERATOR_IN_A_ROW),
            Arguments.of("12 45 / 20 + 3", INPUT_CONTAINS_OPERATOR_IN_A_ROW)

        )
    }
}
