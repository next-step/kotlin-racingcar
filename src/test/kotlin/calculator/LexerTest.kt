package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec

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
})
