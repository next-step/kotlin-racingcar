package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import calculator.Operator.Companion.getOperator
import calculator.StringExpression.parseToMathExpression
import java.util.stream.Stream

@DisplayName("문자열 수식을 계산 가능한 수식(`MathExpression`)으로 변경하는 함수 테스트")
internal class StringExpressionKtTest {
    @DisplayName("주어진 문자열 수식이 비어있는 경우 예외 테스트")
    @ParameterizedTest
    @MethodSource("blankStringExpression")
    fun blankStringExpressionTest(
        stringExpression: String,
        expectedException: Exception,
    ) {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy() {
            parseToMathExpression(stringExpression)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(stringExpression)
    }

    @DisplayName("주어진 문자열 수식이 올바르지 않은 경우 예외 테스트")
    @ParameterizedTest
    @MethodSource("invalidStringExpression")
    fun invalidStringExpressionTest(
        stringExpression: String,
        expectedException: Exception,
    ) {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy() {
            parseToMathExpression(stringExpression)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(stringExpression)
    }

    @DisplayName("주어진 문자열 수식이 올바른 경우 `MathExpression` 반환 테스트")
    @ParameterizedTest
    @MethodSource("validStringExpression")
    fun validStringExpressionTest(stringExpression: String) {
        // Arrange
        val operands = mutableListOf<Operand>()
        val operators = mutableListOf<Operator>()
        initOperandsAndOperators(stringExpression, operands, operators)

        // Act
        val mathExpression = parseToMathExpression(stringExpression)

        // Assert
        assertThat(mathExpression.operands).isEqualTo(operands)
        assertThat(mathExpression.operators).isEqualTo(operators)
    }

    companion object {
        private val illegalArgumentException = IllegalArgumentException()

        @JvmStatic
        fun blankStringExpression(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("", illegalArgumentException),
                Arguments.of("  ", illegalArgumentException),
                Arguments.of("                          ", illegalArgumentException),
            )
        }

        @JvmStatic
        fun invalidStringExpression(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1+2", illegalArgumentException),
                Arguments.of("1 + 2 + +", illegalArgumentException),
                Arguments.of("1 2 3", illegalArgumentException),
                Arguments.of("* / -", illegalArgumentException),
                Arguments.of("* 1 / 2 -", illegalArgumentException),
            )
        }

        @JvmStatic
        fun validStringExpression(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 + 2"),
                Arguments.of("1 + 2 + 3"),
                Arguments.of("1 * 2 * 3"),
                Arguments.of("10 * 8 / 2"),
                Arguments.of("1 + 1 + 1 + 1 + 1 + 1 + 1"),
            )
        }

        private fun initOperandsAndOperators(
            expression: String,
            operands: MutableList<Operand>,
            operators: MutableList<Operator>
        ) {
            val numberRegex = Regex("^[+-]?\\d+$")
            val elements: List<String> = expression.trim().split(" ")

            for (element in elements) {
                if (element.matches(numberRegex)) {
                    operands.add(Operand(element.toInt()))
                    continue
                }

                operators.add(getOperator(element))
            }
        }
    }
}
