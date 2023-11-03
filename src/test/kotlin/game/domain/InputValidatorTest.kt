package game.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "a", "!"])
    fun `값이 1보다 큰 숫자가 아니면 예외를 던진다`(input: String) {
        // given
        val inputValidator = InputValidator()

        // when
        Assertions.assertThatThrownBy { inputValidator.validateCount(input) }
            .isInstanceOf(IllegalArgumentException::class.java).hasMessage(ErrorMessage.INVALID_INPUT_ERROR_MSG.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "25", "999"])
    fun `값이 1보다 큰 숫자이면 예외를 던지지 않는다`(input: String) {
        // given
        val inputValidator = InputValidator()

        // when
        inputValidator.validateCount(input)
    }
}
