package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    "정상: 곱셈 테스트" {
        val calculator = Calculator(SimpleExpressionParser())
        calculator.calculate("5 * 3") shouldBe 15
    }

    "정상: 덧셈 테스트" {
        val calculator = Calculator(SimpleExpressionParser())
        calculator.calculate("5 + 3") shouldBe 8
    }

    "정상: 뺄셈 테스트" {
        val calculator = Calculator(SimpleExpressionParser())
        calculator.calculate("5 - 3") shouldBe 2
    }

    "정상: 나눗셈 테스트" {
        val calculator = Calculator(SimpleExpressionParser())
        calculator.calculate("9 / 3") shouldBe 3
    }

    "정상: 여러 연산 테스트" {
        val calculator = Calculator(SimpleExpressionParser())
        calculator.calculate("9 / 3 * 2 + 3") shouldBe 9
        calculator.calculate("9 * 3 / 3 - 3") shouldBe 6
    }

    "예외: 지원하지 않는 기호" {
        shouldThrow<IllegalArgumentException> {
            val calculator = Calculator(SimpleExpressionParser())
            calculator.calculate("10 ㅁ 10")
        }
    }

    "예외: 연산식이 올바르지 않은 경우" {
        shouldThrow<IllegalArgumentException> {
            val calculator = Calculator(SimpleExpressionParser())
            calculator.calculate("7 / * 5 -")
        }
        shouldThrow<IllegalArgumentException> {
            val calculator = Calculator(SimpleExpressionParser())
            calculator.calculate("9 * 3 -")
        }
    }

    "예외: 수식에 공백 문자 포함" {
        shouldThrow<IllegalArgumentException> {
            val calculator = Calculator(SimpleExpressionParser())
            calculator.calculate("")
        }

        shouldThrow<IllegalArgumentException> {
            val calculator = Calculator(SimpleExpressionParser())
            calculator.calculate(" ")
        }
    }
})
