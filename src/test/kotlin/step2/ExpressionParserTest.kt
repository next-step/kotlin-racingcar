package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExpressionParserTest {
    @Test
    internal fun `연산자를 Operand 타입 그리고 피연산자를 Operator 타입으로 파싱`() {
        val sut = ExpressionParser()
        val actual = sut.parse(listOf("1", "+", "2"))
        val expected = listOf(Operand("1"), Operator.of("+"), Operand("2"))
        assertThat(actual).containsExactlyElementsOf(expected)
    }
}
