package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

@Suppress("NonAsciiCharacters")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TokenTest {

    @ParameterizedTest
    @MethodSource
    fun `식에 알맞은 토큰들을 반환`(arg: TokensArg) {
        assertThat(getTokens(arg.expression)).isEqualTo(arg.result)
    }

    @Suppress("unused")
    private fun `식에 알맞은 토큰들을 반환`(): List<TokensArg> {
        return listOf(
            TokensArg(
                "3 + 11 /",
                listOf(
                    Token(Token.Type.NUMBER, "3"),
                    Token(Token.Type.OPERATOR, "+"),
                    Token(Token.Type.NUMBER, "11"),
                    Token(Token.Type.OPERATOR, "/")
                )
            ),
            TokensArg(
                " * 11 -",
                listOf(
                    Token(Token.Type.OPERATOR, "*"),
                    Token(Token.Type.NUMBER, "11"),
                    Token(Token.Type.OPERATOR, "-")
                )
            ),
            TokensArg(
                " -3.2 + -11 ",
                listOf(
                    Token(Token.Type.NUMBER, "-3.2"),
                    Token(Token.Type.OPERATOR, "+"),
                    Token(Token.Type.NUMBER, "-11")
                )
            ),
        )
    }

    data class TokensArg(
        val expression: String,
        val result: List<Token>,
    )

    @Test
    fun `지원하지 않는 연산자일 경우 예외`() {
        assertThatThrownBy {
            getTokens("32.a - 1")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("32.a은 지원하지 않는 (피)연산자입니다.")
    }
}
