package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `입력값이 빈 공백 문자일 경우 예외를 던진다`(input: String) {
        Assertions.assertThatThrownBy {
            // when
            CalculatorValidator.validateInput(input)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo(ErrorMessage.NULL_OR_BLANK_ERROR_MSG.message)
    }

    @Test
    fun `입력값이 null일 경우 예외를 던진다`() {
        Assertions.assertThatThrownBy {
            // when
            CalculatorValidator.validateInput(null)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo(ErrorMessage.NULL_OR_BLANK_ERROR_MSG.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2", "1 + 2 * 3 / 4", "1 + 2 * 3 / 4 - 5"])
    fun `입력값이 유효한 경우 입력값을 그대로 반환한다`(input: String) {
        // when
        val actual = CalculatorValidator.validateInput(input)

        // then
        Assertions.assertThat(actual).isEqualTo(input)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2 * 3 / 4 - 5 +", "1 + 2 * 3 / 4 - 5 + 6 /", "1 + 2 * 3 / 4 - 5 + 6 / 7 *"])
    fun `입력값이 유효하지 않은 경우 예외를 던진다`(input: String) {
        Assertions.assertThatThrownBy {
            // when
            CalculatorValidator.validateInput(input)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo(ErrorMessage.INVALID_INPUT_ERROR_MSG.message)
    }
}
