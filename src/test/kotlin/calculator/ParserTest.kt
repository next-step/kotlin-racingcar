package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ParserTest : StringSpec({
    "문자열로된 수식을 List 로 파싱합니다." {
        val parser = Parser()
        val expression = Expression("2 + 3 * 4 / 2")
        val parsedExpression = parser.parse(expression)
        parsedExpression shouldBe listOf("2", "+", "3", "*", "4", "/", "2")
    }
})
