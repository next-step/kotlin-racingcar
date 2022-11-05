package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

internal class ParserTest : FunSpec({
    context("널 값이나 빈 문자열은 예외를 던진다.") {
        withData(
            nameFn = { "공백 값들 테스트" },
            ts = listOf(null, "", " ", "      ")
        ) { rawString ->
            shouldThrow<IllegalArgumentException> {
                Parser.parse(rawString)
            }
        }
    }

    context("정상적으로 계산식을 파싱한다.") {
        withData(
            nameFn = { "$it" },
            ts = listOf(
                "2 + 3" to Expression(listOf("2", "+", "3")),
                "2     + 3 / 5" to Expression(listOf("2", "+", "3", "/", "5")),
                "2 * 5 /     2" to Expression(listOf("2", "*", "5", "/", "2"))
            )
        ) { (rawString, parsedData) ->
            Parser.parse(rawString) shouldBe parsedData
        }
    }
})
