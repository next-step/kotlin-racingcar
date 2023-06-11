package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class SimpleExpressionParserTest : StringSpec({
    "수식에 지원하지 않는 연산자가 포함되어 있을때, 예외를 throw 한다" {
        shouldThrow<IllegalArgumentException> {
            val calculator = Calculator(SimpleExpressionParser())
            calculator.calculate("10 ㅁ 10")
        }
    }

    "연산자로 끝나는 잘못된 식이 주어졌을때, 예외를 throw 한다" {
        shouldThrow<IllegalArgumentException> {
            val calculator = Calculator(SimpleExpressionParser())
            calculator.calculate("9 * 3 -")
        }
    }

    "연산자가 연속으로 나오는 잘못된 식이 주어졌을때, 예외를 throw 한다" {
        shouldThrow<IllegalArgumentException> {
            val calculator = Calculator(SimpleExpressionParser())
            calculator.calculate("7 / * 5 -")
        }
    }

    "주어진 수식이 EmptyString일때, 예외를 throw 한다" {
        shouldThrow<IllegalArgumentException> {
            val calculator = Calculator(SimpleExpressionParser())
            calculator.calculate("")
        }
    }

    "주어진 수식이 공백일때, 예외를 throw 한다" {
        shouldThrow<IllegalArgumentException> {
            val calculator = Calculator(SimpleExpressionParser())
            calculator.calculate(" ")
        }
    }
})
