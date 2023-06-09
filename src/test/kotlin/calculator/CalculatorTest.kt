package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    "덧셈" {
        Operator.PLUS.operation(1, 3) shouldBe 4
    }

    "뺄셈" {
        Operator.MINUS.operation(1, 3) shouldBe -2
    }

    "곱셈" {
        Operator.MULTIPLY.operation(1, 3) shouldBe 3
    }

    "나눗셈" {
        Operator.DIVIDE.operation(3, 1) shouldBe 3
    }

    "입력값이 null이거나 빈 공백 문자일 경우" {
        shouldThrow<IllegalArgumentException> {
            Calculator.execute("")
        }

        shouldThrow<IllegalArgumentException> {
            Calculator.execute(null)
        }
    }
    "사칙연산 기호가 아닌 경우" {
        shouldThrow<IllegalArgumentException> {
            Calculator.execute("1 + 3 $ 2 ")
        }
    }

    "사칙 연산을 모두 포함하는 기능 구현" {
        Calculator.execute("5 + 4 - 1 * 6 / 2") shouldBe 24
    }
})
