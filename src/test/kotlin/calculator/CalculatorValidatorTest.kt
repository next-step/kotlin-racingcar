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
    @ValueSource(ints = [4, 6, 20])
    fun `사이즈가 짝수일 경우 예외를 던진다`(size: Int) {
        Assertions.assertThatThrownBy {
            // when
            CalculatorValidator.validateSize(size)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo(ErrorMessage.ODD_SIZE_REQUIREMENT_MSG.message)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `길이가 3보다 작을 경우 예외를 던진다`(size: Int) {
        Assertions.assertThatThrownBy {
            // when
            CalculatorValidator.validateSize(size)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo(ErrorMessage.MINIMUM_SIZE_REQUIREMENT_MSG.message)
    }
}
