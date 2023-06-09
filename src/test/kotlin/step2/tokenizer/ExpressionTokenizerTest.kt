package step2.tokenizer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExpressionTokenizerTest {
    @Test
    internal fun `입력 순서대로 토큰화`() {
        val sut = ExpressionTokenizer()
        val result = sut.tokenize(" 1 +2 *  3/4")
        assertThat(result).containsExactly("1", "+", "2", "*", "3", "/", "4")
    }
}
