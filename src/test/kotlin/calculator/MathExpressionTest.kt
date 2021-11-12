package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("수식을 표현하는 객체인 `MathExpression` 테스트")
internal class MathExpressionTest {
    @DisplayName("주어진 연산자 수가 피연산자 수보다 1개 많으면 `MathExpression` 객체 생성 시 성공")
    @ParameterizedTest
    @MethodSource("numberOfOperandIsOneGreaterThanNumberOfOperator")
    fun createMathExpressionIsSuccessIfGivenNumberOfOperandIsOneGreaterThanNumberOfOperator(
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

    @DisplayName("주어진 연산자 수가 피연산자 수보다 1개 많지 않으면 `MathExpression` 객체 생성 시 실패")
    @ParameterizedTest
    @MethodSource("numberOfOperandIsNotOneGreaterThanNumberOfOperator")
    fun createMathExpressionIsFailIfGivenNumberOfOperandIsNotOneGreaterThanNumberOfOperator(
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
        fun numberOfOperandIsOneGreaterThanNumberOfOperator(): Stream<Arguments> {
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
        fun numberOfOperandIsNotOneGreaterThanNumberOfOperator(): Stream<Arguments> {
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
