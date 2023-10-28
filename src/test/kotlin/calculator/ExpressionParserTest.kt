package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExpressionParserTest {
    @Test
    fun `숫자는 Term으로 파싱한다`() {
        val parser = ExpressionParser()

        val actual = parser.parse("1").first()
        val expected = ExpressionElement.Term(1)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `연산자는 Operator로 파싱한다`() {
        val parser = ExpressionParser()

        val actual = parser.parse("+").first()
        val expected = ExpressionElement.Operator.Add

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `공백으로 나뉜 순서대로 파싱한다`() {
        val parser = ExpressionParser()

        val actual = parser.parse("1 1 + +").map { it::class }
        val expected = listOf(
            ExpressionElement.Term::class,
            ExpressionElement.Term::class,
            ExpressionElement.Operator::class,
            ExpressionElement.Operator::class,
        )

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `알수 없는 문자는 에러를 발생한다`() {
        val parser = ExpressionParser()

        assertThrows<IllegalArgumentException> {
            parser.parse("a")
        }
    }
}
