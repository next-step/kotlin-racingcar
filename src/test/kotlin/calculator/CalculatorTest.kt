package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {

    @Test
    fun execute() {
        assertThat(Calculator.execute(ExpressionParser.parse(" 3 + 4 / 2 + 5 "))).isEqualTo(8.5)
        assertThat(Calculator.execute(ExpressionParser.parse("-3.5 * 2"))).isEqualTo(-7.0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 / 0", "0.0 / 0.0"])
    fun divideZero(expression: String) {
        assertThat(Double.NaN.equals(Calculator.execute(ExpressionParser.parse(expression)))).isTrue()
    }
}
