package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource


class OperatorTests {
    @Nested
    @DisplayName("사칙연산 계산 테스트")
    inner class OperatorExpression {
        @Test
        fun `덧셈 성공`() {
            assertThat(Operator.PLUS.expression(3.0, 4.0)).isEqualTo(7.0)
        }

        @Test
        fun `뺄셈 성공`() {
            assertThat(Operator.MINUS.expression(10.0, 3.6)).isEqualTo(6.4)
        }

        @Test
        fun `곱셈 성공`() {
            assertThat(Operator.TIMES.expression(10.0, 3.6)).isEqualTo(36.0)
        }

        @Test
        fun `나눗셈 성공`() {
            assertThat(Operator.DIVIDE.expression(10.0, 2.0)).isEqualTo(5.0)
        }

        @Test
        fun `나눗셈 실패 - 0으로 나눌 경우 IllegalArgumentException 발생`() {
            assertThatIllegalArgumentException()
                .isThrownBy { Operator.DIVIDE.expression(10.0, 0.0) }
                .withMessage(Const.ErrorMsg.CANNOT_DIVIDE_TO_ZERO_ERROR_MSG)
        }
    }

    @Nested
    @DisplayName("사칙연산 기호 Valid 테스트")
    inner class OperatorCheckValidation {
        @ParameterizedTest
        @ValueSource(strings = ["+", "-", "*", "/"])
        fun `사칙연산에 포함된 기호는 valid 성공`(symbol: String?) {
            assertDoesNotThrow { Operator.checkValidation(symbol) }
        }

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = ["  ", "!", "1", "^"])
        fun `사칙연산에 포함되지 않는 기호는 valid 실패 - IllegalArgumentException 발생`(symbol: String?) {
            assertThatIllegalArgumentException()
                .isThrownBy { Operator.checkValidation(symbol) }
                .withMessage(Const.ErrorMsg.OPERATOR_IS_NOT_VALID_ERROR_MSG)
        }
    }
}