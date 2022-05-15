package expressioncalculator.calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExpressionParserTest {
    @Test
    fun `연산 문자열을 받아 Calculation 리스트를 반환한다`() {
        val calculations = ExpressionParser.parse("2 + 3 * 4 / 2")
        val calculations2 = listOf(
            Calculation(Operator.PLUS, 2.0),
            Calculation(Operator.PLUS, 3.0),
            Calculation(Operator.MULTIPLY, 4.0),
            Calculation(Operator.DIVIDE, 2.0),
        )

        assertThat(calculations).isEqualTo(calculations2)
    }

    @ParameterizedTest
    @ValueSource(strings = ["* 2 + 3 * 4 / 2", "* * 3 * 3 * 4 / 2", "3 4 3 * 3 * 4 / 2"])
    fun `숫자 - 연산자 순서로 되어 있지 않다면 IllegalArgumentException이 발생한다`(expression: String) {
        Assertions.assertThatThrownBy {
            ExpressionParser.parse(expression)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["3  3 * 4 / 2", "3 +  * 4 / 2"])
    fun `숫자나 연산자에 공백이 존재한다면 IllegalArgumentException이 발생한다`(expression: String) {
        Assertions.assertThatThrownBy {
            ExpressionParser.parse(expression)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + ㅋ * 4 / 2", "two + 3 * 4 / 2"])
    fun `숫자 위치에 숫자로 변환될 수 없는 값이 온다면 NumberFormatException이 발생한다`(expression: String) {
        Assertions.assertThatThrownBy {
            ExpressionParser.parse(expression)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
