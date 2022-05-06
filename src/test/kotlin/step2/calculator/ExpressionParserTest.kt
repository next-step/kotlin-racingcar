package step2.calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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

    @Test
    fun `숫자 - 연산자 순서로 되어 있지 않다면 IllegalArgumentException이 발생한다`() {
        Assertions.assertThatThrownBy {
            ExpressionParser.parse("* 2 + 3 * 4 / 2")
        }.isInstanceOf(IllegalArgumentException::class.java)

        Assertions.assertThatThrownBy {
            ExpressionParser.parse("* * 3 * 3 * 4 / 2")
        }.isInstanceOf(IllegalArgumentException::class.java)

        Assertions.assertThatThrownBy {
            ExpressionParser.parse("3 4 3 * 3 * 4 / 2")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `숫자나 연산자에 공백이 존재한다면 IllegalArgumentException이 발생한다`() {
        Assertions.assertThatThrownBy {
            ExpressionParser.parse("3  3 * 4 / 2")
        }.isInstanceOf(IllegalArgumentException::class.java)

        Assertions.assertThatThrownBy {
            ExpressionParser.parse("3 +  * 4 / 2")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `숫자 위치에 숫자로 변환될 수 없는 값이 온다면 NumberFormatException이 발생한다`() {
        Assertions.assertThatThrownBy {
            ExpressionParser.parse("2 + ㅋ * 4 / 2")
        }.isInstanceOf(NumberFormatException::class.java)

        Assertions.assertThatThrownBy {
            ExpressionParser.parse("two + 3 * 4 / 2")
        }.isInstanceOf(NumberFormatException::class.java)
    }
}
