package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    "덧셈 테스트" {
        Calculator.calculate("2 + 5") shouldBe 7
    }

    "뺄셈 테스트" {
        Calculator.calculate("2 - 5") shouldBe -3
    }

    "곱셈 테스트" {
        Calculator.calculate("2 * 3") shouldBe 6
    }

    "나눗셈 테스트" {
        Calculator.calculate("5 / 2") shouldBe 2
    }

    "복합연산 테스트" {
        Calculator.calculate("2 + 3 * 4 / 2") shouldBe 10
        Calculator.calculate("5 - 2 * 2") shouldBe 6
    }

    "연산식이 올바르지 않은 경우 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            Calculator.calculate("2 * * 3 2")
        }
        shouldThrow<IllegalArgumentException> {
            Calculator.calculate("2 * 3 -")
        }
    }

    "공백 문자를 입력한 경우 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            Calculator.calculate(" ")
        }

        shouldThrow<IllegalArgumentException> {
            Calculator.calculate("")
        }
    }

    "사칙연산 기호가 아닌 경우 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            Calculator.calculate("1 & 2")
        }
    }
})
