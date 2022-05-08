package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class LexerTest : FreeSpec({

    "예외 상황" - {
        listOf(
            "null" to null,
            "빈 문자열" to "",
            "공백 문자열" to " \r\n\t",
            "잘못된 문자열" to "invalid",
        ).forEach { (type, input) ->
            "$type 을 제공하면 에러가 발생한다" {
                shouldThrow<IllegalArgumentException> {
                    Lexer.new(input)
                }
            }
        }
    }

    "입력에 대한 토큰을 순서대로 가져온다" {
        // given
        val input = "2 + 3 * 4   / 2"

        // when
        val lexer = Lexer.new(input)

        // then
        lexer.next() shouldBe Token.Number(2)
        lexer.next() shouldBe Token.Plus
        lexer.next() shouldBe Token.Number(3)
        lexer.next() shouldBe Token.Asterisk
        lexer.next() shouldBe Token.Number(4)
        lexer.next() shouldBe Token.Slash
        lexer.next() shouldBe Token.Number(2)
        lexer.next() shouldBe Token.EOF
        lexer.next() shouldBe Token.EOF
    }
})
