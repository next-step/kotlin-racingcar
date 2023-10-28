package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExpressionParserTest {
    @Test
    fun `숫자는 Term으로 파싱한다`() {
        val actual = ExpressionParser.parse("1").first()
        val expected = ExpressionElement.Term(1)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `연산자는 Operator로 파싱한다`() {
        val actual = ExpressionParser.parse("+").first()
        val expected = ExpressionElement.Operator.Add

        assertThat(actual).isEqualTo(expected)
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
