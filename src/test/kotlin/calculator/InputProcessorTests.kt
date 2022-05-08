package calculator

import calculator.Const.ErrorMsg
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class InputProcessorTests {

    @Nested
    @DisplayName("입력값이 null 이거나 빈칸인지 테스트")
    inner class CheckInputIsEmptyOrBlank {
        @ParameterizedTest
        @ValueSource(strings = ["3", "1+2", "1 + 2"])
        fun `입력값이 Null 이나 빈칸이 아닐 경우 성공`(expression: String) {
            assertDoesNotThrow { InputProcessor.checkInputIsEmpty(expression) }
        }

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = ["  ", "\t"])
        fun `입력값이 null 이거나 빈칸이면 실패 - IllegalArgumentException 발생`(expression: String?) {
            assertThatIllegalArgumentException()
                .isThrownBy { InputProcessor.checkInputIsEmpty(expression) }
                .withMessage(ErrorMsg.INPUT_IS_EMPTY_OR_BLANK_ERROR_MSG)
        }
    }

    @Nested
    @DisplayName("입력값 operator / operand list 로 분리 테스트")
    inner class SplitInput {
        @ParameterizedTest
        @ValueSource(strings = ["1 + 2", "2 - 3", "1 * 3 / 4"])
        fun `올바른 입력값일 경우 리스트 반환 성공 - 에러 발생하지 않음`(expression: String) {
            assertDoesNotThrow { InputProcessor.splitInputToPairList(expression) }
        }

        @ParameterizedTest
        @ValueSource(strings = ["1", "1 +", "1+2"])
        fun `입력값을 " "로 구분했을 때, 사이즈가 3 미만인 경우 - IllegalArgumentException 에러 발생`(expression: String) {
            assertThatIllegalArgumentException()
                .isThrownBy { InputProcessor.splitInputToPairList(expression) }
                .withMessage(ErrorMsg.INPUT_SIZE_IS_WRONG_ERROR_MSG)
        }

        @ParameterizedTest
        @ValueSource(strings = ["1 + 2 -", "4.3 * 2 - 1 +"])
        fun `입력값을 " "로 구분했을 때, 사이즈가 짝수인 경우 - IllegalArgumentException 에러 발생`(expression: String) {
            assertThatIllegalArgumentException()
                .isThrownBy { InputProcessor.splitInputToPairList(expression) }
                .withMessage(ErrorMsg.INPUT_SIZE_IS_WRONG_ERROR_MSG)
        }

        @ParameterizedTest
        @ValueSource(strings = ["1 + 2 -+ 3", "1 ^ 2", "1 a 3"])
        fun `입력값에 잘못된 연산자가 있는 경우 - IllegalArgumentException 에러 발생`(expression: String) {
            assertThatIllegalArgumentException()
                .isThrownBy { InputProcessor.splitInputToPairList(expression) }
                .withMessage(ErrorMsg.OPERATOR_IS_NOT_VALID_ERROR_MSG)
        }

        @ParameterizedTest
        @ValueSource(strings = ["1 + 2a", "1 * b", "1 / 3+1"])
        fun `입력값에 잘못된 피연산자가 있는 경우 - IllegalArgumentException 에러 발생`(expression: String) {
            assertThatIllegalArgumentException()
                .isThrownBy { InputProcessor.splitInputToPairList(expression) }
                .withMessage(ErrorMsg.OPERAND_IS_NOT_NUMBER_ERROR_MSG)
        }
    }
}
