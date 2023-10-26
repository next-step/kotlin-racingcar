package game

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "a", "!"])
    fun `값이 1보다 큰 숫자가 아니면 예외를 던진다`(input: String) {
        // when
        Assertions.assertThatThrownBy { InputValidator.validateInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java).hasMessage(ErrorMessage.INVALID_INPUT_ERROR_MSG.message)
    }
}
