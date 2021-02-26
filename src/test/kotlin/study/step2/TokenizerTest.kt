package study.step2

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class TokenizerTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "      "])
    fun `isBlank가 빈공백 문자에 true를 리턴하는지`(input: String) {
        assertTrue(input.isBlank())
    }

    @Test
    fun `null을 입력할 경우`() {
        assertThatThrownBy {
            Tokenizer().splitExpression(null)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("IllegalArgumentException")
    }

    @Test
    fun `공백을 입력할 경우`() {
        assertThatThrownBy {
            Tokenizer().splitExpression(" ")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
