package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("수식을 표현하는 객체인 MathExpression 테스트")
internal class MathExpressionTest {
    @DisplayName("주어진 연산자와 피연산자가 올바른 경우 MathExpression 객체 생성 성공")
    @ParameterizedTest
    @MethodSource("correctOperandsAndOperators")
    fun given_CorrectOperandsAndOperators_when_CreateMathExpression_then_Success(
        operands: List<Operand>,
        operators: List<Operator>
    ) {
        // Arrange
        // Act
        val mathExpression = MathExpression(
            _operands = operands,
            _operators = operators
        )

        // Assert
        assertThat(mathExpression.operands).isEqualTo(operands)
        assertThat(mathExpression.operators).isEqualTo(operators)
    }

    @DisplayName("주어진 연산자와 피연산자가 올바르지 않은 경우 MathExpression 객체 생성 실패")
    @ParameterizedTest
    @MethodSource("incorrectOperandsAndOperators")
    fun given_IncorrectOperandsAndOperators_when_CreateMathExpression_then_Fail(
        operands: List<Operand>,
        operators: List<Operator>,
        expectedException: Exception,
        containErrorMessage: String
    ) {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy() {
            MathExpression(
                _operands = operands,
                _operators = operators
            )
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(containErrorMessage)
    }

    companion object {
        private const val illegalArgumentErrorMessage = "Failed requirement"
        private val illegalArgumentException = IllegalArgumentException()

        @JvmStatic
        fun correctOperandsAndOperators(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(Operand(1), Operand(2)),
                    listOf(Operator.getOperator("+")),
                ),
                Arguments.of(
                    listOf(Operand(3), Operand(2)),
                    listOf(Operator.getOperator("*")),
                ),
                Arguments.of(
                    listOf(Operand(1_000_000_000), Operand(100_000_000)),
                    listOf(Operator.getOperator("/")),
                ),
                Arguments.of(
                    listOf(Operand(2_000_000_000), Operand(1_000_000_000)),
                    listOf(Operator.getOperator("-")),
                ),
                Arguments.of(
                    listOf(Operand(7), Operand(2), Operand(3), Operand(9)),
                    listOf(Operator.getOperator("*"), Operator.getOperator("+"), Operator.getOperator("-")),
                ),
                Arguments.of(
                    listOf(Operand(10), Operand(2), Operand(3), Operand(9)),
                    listOf(Operator.getOperator("+"), Operator.getOperator("/"), Operator.getOperator("*")),
                ),
                Arguments.of(
                    listOf(Operand(3), Operand(7)),
                    listOf(null),
                ),
                Arguments.of(
                    listOf(null, null),
                    listOf(Operator.getOperator("+")),
                ),
            )
        }

        @JvmStatic
        fun incorrectOperandsAndOperators(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(Operand(1), Operand(2)),
                    listOf(Operator.getOperator("+"), Operator.getOperator("-")),
                    illegalArgumentException,
                    illegalArgumentErrorMessage
                ),
                Arguments.of(
                    listOf(Operand(3), Operand(7)),
                    listOf(Operator.getOperator("+"), Operator.getOperator("-"), Operator.getOperator("/")),
                    illegalArgumentException,
                    illegalArgumentErrorMessage
                ),
                Arguments.of(
                    listOf(Operand(3), Operand(7), Operand(7), Operand(7), Operand(7), Operand(7)),
                    listOf(Operator.getOperator("+"), Operator.getOperator("*"), Operator.getOperator("/")),
                    illegalArgumentException,
                    illegalArgumentErrorMessage
                ),
            )
        }
    }
}
