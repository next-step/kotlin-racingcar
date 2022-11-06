package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class ParserTest : StringSpec({
    "문자열로된 수식을 List 로 파싱합니다." {
        val parser = Parser()
        val input = Input("2 + 3 * 4 / 2")
        val parsedExpression = parser.parse(input)
        parsedExpression shouldBe listOf("2", "+", "3", "*", "4", "/", "2")
    }

    "문자열 파서의 입력은 null 일 수 없습니다." {
        shouldThrow<IllegalArgumentException> {
            val parser = Parser()
            val input = Input(null)
            parser.parse(input)
        }
    }
})
