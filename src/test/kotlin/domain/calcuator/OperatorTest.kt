package domain.calcuator

import domain.caculator.Operator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class OperatorTest {

    @ParameterizedTest(name = "{1} {0} {2} = {3}")
    @MethodSource("operatorTextFixture")
    fun `연산자 테스트`(operator: Operator, number1: Int, number2: Int, result: Int) {
        assertThat(operator.calculate(number1, number2)).isEqualTo(result)
    }

    companion object {
        @JvmStatic
        fun operatorTextFixture(): List<Arguments> {
            return listOf(
                Arguments.of(Operator.PLUS, 1, 1, 2),
                Arguments.of(Operator.MINUS, 1, 1, 0),
                Arguments.of(Operator.MULTIPLE, 1, 1, 1),
                Arguments.of(Operator.DIVISION, 1, 1, 1),
            )
        }
    }
}
