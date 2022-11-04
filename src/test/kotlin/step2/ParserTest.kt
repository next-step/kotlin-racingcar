package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize

internal class ParserTest : StringSpec({
    "raw 수식 파싱" {
        val rawExpress = "2 + 3 * 4 / 2" // 10

        val expressions: List<Pair<Operator, Double>> = Parser().parse(rawExpress)

        expressions shouldHaveSize 4
    }

    "입력값이 빈 값이면 예외가 발생" {
        val emptyExpression = " "

        shouldThrow<IllegalArgumentException> {
            Parser().parse(emptyExpression)
        }
    }

    "(피)연산자 수가 올바르지 않으면 예외가 발생" {
        val wrongExpression = "2 + 3 *"

        shouldThrow<IllegalArgumentException> {
            Parser().parse(wrongExpression)
        }
    }

    "올바르지 않는 연산 기호가 있다면 예외가 발생" {
        val wrongExpression = "2 @ 3"

        shouldThrow<IllegalArgumentException> {
            Parser().parse(wrongExpression)
        }
    }

    "중위 표현식이 아닌 수식이면 예외가 발생" {
        val wrongExpression = "2 3 +"

        shouldThrow<IllegalArgumentException> {
            Parser().parse(wrongExpression)
        }
    }
})
