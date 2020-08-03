package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ExpressionCheckerTest {

    @ParameterizedTest
    @MethodSource(value = ["provideEmptyExpression"])
    fun `number or operator is empty`(number: List<Int>, expression: List<Operator>, result: Boolean) {
        assertThat(ExpressionChecker.isEmpty(number, expression)).isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource(value = ["provideValidExpression"])
    fun `valid expression size`(number: List<Int>, expression: List<Operator>) {
        assertThat(ExpressionChecker.isValidExpressionSize(number, expression))
            .isEqualTo(true)
    }

    @ParameterizedTest
    @MethodSource(value = ["provideInvalidExpression"])
    fun `invalid expression size`(number: List<Int>, expression: List<Operator>) {
        assertThat(ExpressionChecker.isValidExpressionSize(number, expression))
            .isEqualTo(false)
    }

    companion object {
        @JvmStatic
        fun provideEmptyExpression(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2), emptyList<Operator>(), true),
                Arguments.of(emptyList<Int>(), listOf(Operator.MUL), true),
                Arguments.of(emptyList<Int>(), emptyList<Operator>(), true)
            )
        }

        @JvmStatic
        fun provideValidExpression(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2), listOf(Operator.MUL)),
                Arguments.of(listOf(1, 2, 4, 5), listOf(Operator.MUL, Operator.SUB, Operator.ADD))
            )
        }

        @JvmStatic
        fun provideInvalidExpression(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2), listOf(Operator.MUL, Operator.ADD)),
                Arguments.of(listOf(1, 2, 4, 5), listOf(Operator.MUL))
            )
        }
    }
}
