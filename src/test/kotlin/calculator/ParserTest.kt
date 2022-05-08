package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec

internal class ParserTest : FreeSpec({
    "예외 상황" - {
        listOf(
            "숫자가 연속해서 2번 나오는 경우" to "1 2.3",
            "연산자가 연속해서 2번 나오는 경우" to "* +",
            "연산자 뒤에 숫자가 없는 경우" to "1 +",
            "연산자부터 시작하는 경우" to "/ 2 + 3",
        ).forEach { (title, input) ->
            "$title 에러가 발생한다" {
                // given
                val lexer = Lexer.new(input)

                // when
                shouldThrow<IllegalArgumentException> {
                    Parser.parse(lexer)
                }
            }
        }
    }
})
