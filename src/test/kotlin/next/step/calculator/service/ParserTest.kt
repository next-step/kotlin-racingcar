package next.step.calculator.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class ParserTest : FunSpec({
    context("문자열을 공백 기준으로 분리하여 리스트 생성") {
        data class ParseExpected(val s: String, val expected: List<String>)
        withData(
            nameFn = { "\"${it.s}\" -> ${it.expected}" },
            ParseExpected("", listOf("")),
            ParseExpected(" ", listOf("", "")),
            ParseExpected("2", listOf("2")),
            ParseExpected("2 + 3", listOf("2", "+", "3")),
            ParseExpected("2 + 3 * 4 / 2", listOf("2", "+", "3", "*", "4", "/", "2")),
        ) { (s, expected) ->
            Parser.parse(s) shouldBe expected
        }
    }
})
