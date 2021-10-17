package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class ParserTest {

    @Test
    fun `정상적인 파싱`() {
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

    @Test
    fun `비정상적인 파싱 - 연산자 자리에 숫자`() {
        val parser = Parser(
            listOf(
                Token(Token.Type.NUMBER, "2"),
                Token(Token.Type.NUMBER, "3"),
                Token(Token.Type.OPERATOR, "*"),
                Token(Token.Type.NUMBER, "4"),
                Token(Token.Type.OPERATOR, "/"),
                Token(Token.Type.NUMBER, "2"),
            )
        )
        assertThatThrownBy {
            parser.parse()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("문법이 잘못되었습니다. 3 근처를 살펴보세요.")
    }

    @Test
    fun `비정상적인 파싱 - 숫자 자리에 연산자`() {
        val parser = Parser(
            listOf(
                Token(Token.Type.NUMBER, "+"),
                Token(Token.Type.NUMBER, "3"),
                Token(Token.Type.OPERATOR, "*"),
                Token(Token.Type.NUMBER, "4"),
                Token(Token.Type.OPERATOR, "/"),
                Token(Token.Type.NUMBER, "2"),
            )
        )
        assertThatThrownBy {
            parser.parse()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("+는 실수가 아닙니다.")
    }

    @Test
    fun `비정상적인 파싱 - 토큰 X`() {
        assertThatThrownBy {
            Parser(emptyList())
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("파싱에 사용될 토큰이 존재하지 않습니다.")
    }
}
