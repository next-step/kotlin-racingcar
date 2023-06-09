package step2.parser

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step2.expression.Operand
import step2.expression.Operator

internal class ExpressionParserTest {
    @Test
    internal fun `연산자를 Operand 타입 그리고 피연산자를 Operator 타입으로 파싱`() {
        val sut = ExpressionParser()
        val actual = sut.parse(listOf("1", "+", "2"))
        val expected = listOf(Operand("1"), Operator.of("+"), Operand("2"))
        assertThat(actual).containsExactlyElementsOf(expected)
    }
}
