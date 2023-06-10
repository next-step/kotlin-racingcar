package step2.tokenizer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step2.expression.ExpressionToken

internal class ExpressionTokenizerTest {
    @Test
    internal fun `입력 순서대로 토큰화`() {
        val sut = ExpressionTokenizer()
        val result = sut.tokenize(" 1 +2 *  3/4")
        assertThat(result).containsExactly(
            ExpressionToken("1"),
            ExpressionToken("+"),
            ExpressionToken("2"),
            ExpressionToken("*"),
            ExpressionToken("3"),
            ExpressionToken("/"),
            ExpressionToken("4")
        )
    }

    @Test
    internal fun `자릿 수에 구애받지 않고 토큰화`() {
        val sut = ExpressionTokenizer()
        val result = sut.tokenize(" 1000 +2 *  3999/4")
        assertThat(result).containsExactly(
            ExpressionToken("1000"),
            ExpressionToken("+"),
            ExpressionToken("2"),
            ExpressionToken("*"),
            ExpressionToken("3999"),
            ExpressionToken("/"),
            ExpressionToken("4")
        )
    }
}
