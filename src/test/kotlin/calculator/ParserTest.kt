package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ParserTest {

    @Test
    fun parse() {
        val result = Parser(
            listOf(
                Token(Token.Type.NUMBER, "2"),
                Token(Token.Type.OPERATOR, "+"),
                Token(Token.Type.NUMBER, "3"),
                Token(Token.Type.OPERATOR, "*"),
                Token(Token.Type.NUMBER, "4"),
                Token(Token.Type.OPERATOR, "/"),
                Token(Token.Type.NUMBER, "2"),
            )
        ).parse().evaluate()

        assertThat(result).isEqualTo(10.0)
    }
}
