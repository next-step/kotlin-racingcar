package domain.calcuator

import domain.caculator.Operator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {

    @ParameterizedTest(name = "{1} {0} {2} = {3}")
    @MethodSource("calculateTextFixture")
    fun `연산자 테스트`(operator: Operator, number1: Int, number2: Int, result: Int) {
        assertThat(operator.calculate(number1, number2)).isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource("operatorTestFixture")
    fun `정상적인 symbol이 들어오면 Operator를 리턴한다`(symbol: String, operator: Operator) {
        assertThat(Operator.of(symbol)).isEqualTo(operator)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "=", "[", "]"])
    fun `잘못된 symbol이 들어오면 NULL이 반환된다`(symbol: String) {
        assertThrows<IllegalArgumentException>("잘못된 연산자 입니다.") { Operator.of(symbol) }
    }

    companion object {

        @JvmStatic
        fun operatorTestFixture(): List<Arguments> {
            return listOf(
                Arguments.of("+", Operator.PLUS),
                Arguments.of("-", Operator.MINUS),
                Arguments.of("*", Operator.MULTIPLE),
                Arguments.of("/", Operator.DIVISION)
            )
        }

        @JvmStatic
        fun calculateTextFixture(): List<Arguments> {
            return listOf(
                Arguments.of(Operator.PLUS, 1, 1, 2),
                Arguments.of(Operator.MINUS, 1, 1, 0),
                Arguments.of(Operator.MULTIPLE, 1, 1, 1),
                Arguments.of(Operator.DIVISION, 1, 1, 1),
            )
        }
    }
}
