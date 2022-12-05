package domain.calcuator

import domain.caculator.Calculator
import domain.caculator.Operator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("expressionTextFixture")
    fun `계산이 올바른지 테스트 하기`(expressions: List<Pair<Operator, Int>>, result: Int) {
        val calculator = Calculator()

        assertThat(calculator.calculate(expressions)).isEqualTo(result)
    }

    companion object {
        @JvmStatic
        fun expressionTextFixture(): List<Arguments> {
            return listOf(
                Arguments.of(listOf(Operator.PLUS to 1, Operator.PLUS to 1,), 2),
                Arguments.of(listOf(Operator.PLUS to 1, Operator.MINUS to 1,), 0),
                Arguments.of(listOf(Operator.PLUS to 1, Operator.MULTIPLE to 1,), 1),
                Arguments.of(listOf(Operator.PLUS to 1, Operator.DIVISION to 1,), 1),
                Arguments.of(listOf(Operator.PLUS to 1, Operator.PLUS to 1, Operator.MINUS to 1,), 1),
                Arguments.of(listOf(Operator.PLUS to 1, Operator.MINUS to 2, Operator.MULTIPLE to 3), -3),
                Arguments.of(listOf(Operator.PLUS to 1, Operator.MULTIPLE to 2, Operator.DIVISION to 2), 1),
                Arguments.of(listOf(Operator.PLUS to 1, Operator.MULTIPLE to 3, Operator.MINUS to 2), 1),
                Arguments.of(listOf(Operator.PLUS to 1, Operator.MULTIPLE to 1, Operator.PLUS to 4), 5)
            )
        }
    }
}
