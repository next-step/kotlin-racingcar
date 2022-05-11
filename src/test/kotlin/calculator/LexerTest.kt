package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

internal class LexerTest : FreeSpec({

    "예외 상황" - {
        listOf(
            "빈 문자열" to "",
            "공백 문자열" to " \r\n\t",
            "잘못된 문자열" to "invalid",
        ).forEach { (type, input) ->
            "$type 을 제공하면 에러가 발생한다" {
                shouldThrow<IllegalArgumentException> {
                    Lexer.from(input)
                }
            }
        }
    }

    "입력에 대한 토큰을 순서대로 가져온다" {
        val input = "2 + 3 * 4.6   / 2"

        val lexer = Lexer.from(input)

        lexer.next() shouldBe Token.Number(2.0)
        lexer.next() shouldBe Token.Plus
        lexer.next() shouldBe Token.Number(3.0)
        lexer.next() shouldBe Token.Asterisk
        lexer.next() shouldBe Token.Number(4.6)
        lexer.next() shouldBe Token.Slash
        lexer.next() shouldBe Token.Number(2.0)
        lexer.next() shouldBe Token.EOF
        lexer.next() shouldBe Token.EOF
    }

    "모든 토큰을 읽은경우에만 isEOF 는 true 로 반환한다" {
        val input = "2"

        val lexer = Lexer.from(input)

        lexer.isEOF().shouldBeFalse()
        lexer.next()
        lexer.isEOF().shouldBeTrue()
    }
})
