package calculator.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TokenizerTest {

    private val tokenizer: Tokenizer = Tokenizer()

    @Test
    fun 토큰나이징() {
        //given
        val input = "1 + 1 - 3"

        //when
        val actual: List<String> = tokenizer.tokenize(input)

        //then
        assertThat(actual).isNotNull
        assertThat(actual).isNotEmpty
        assertThat(actual).isEqualTo(listOf("1", "+", "1", "-", "3"))
    }
}
