package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExpressionParserTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "0"])
    fun `숫자는 Term으로 파싱한다`(number: String) {
        val actual = ExpressionParser.parse(number).first()

        assertThat(actual).isInstanceOf(ExpressionElement.Term::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `연산자는 Operator로 파싱한다`(operatorExpression: String) {
        val actual = ExpressionParser.parse(operatorExpression).first()

        assertThat(actual).isInstanceOf(ExpressionElement.Operator::class.java)
    }

    @Test
    fun `식에서 +는 Add로 파싱한다`() {
        val actual = ExpressionParser.parse("+").first()

        assertThat(actual).isEqualTo(ExpressionElement.Operator.Add)
    }

    @Test
    fun `식에서 -는 Sub로 파싱한다`() {
        val actual = ExpressionParser.parse("-").first()

        assertThat(actual).isEqualTo(ExpressionElement.Operator.Sub)
    }

    @Test
    fun `식에서 *는 Multi로 파싱한다`() {
        val actual = ExpressionParser.parse("*").first()

        assertThat(actual).isEqualTo(ExpressionElement.Operator.Multi)
    }

    @Test
    fun `식에서 slash는 Div로 파싱한다`() {
        val actual = ExpressionParser.parse("/").first()

        assertThat(actual).isEqualTo(ExpressionElement.Operator.Div)
    }

    @Test
    fun `공백으로 나뉜 순서대로 파싱한다`() {
        val actual = ExpressionParser.parse("1 1 + +").map { it::class }
        val expected = listOf(
            ExpressionElement.Term::class,
            ExpressionElement.Term::class,
            ExpressionElement.Operator::class,
            ExpressionElement.Operator::class,
        )

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `숫자 혹은 연산자가 아닌 문자는 에러가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ExpressionParser.parse("a")
        }
    }
}
