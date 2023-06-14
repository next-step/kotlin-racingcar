package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    val calculator = Calculator()

    "기본 사칙연산 테스트" {
        calculator.calculate(1, "+", 2) shouldBe 3
    }

    "입력값 공백과 null 테스트" {
        shouldThrow<IllegalArgumentException> {
            calculator.calculateString("")
        }
        shouldThrow<IllegalArgumentException> {
            calculator.calculateString(" ")
        }
        shouldThrow<IllegalArgumentException> {
            calculator.calculateString(null)
        }
    }

    "사칙 연산 예제 테스트" {
        calculator.calculateString("2 + 3 * 4 / 2") shouldBe 10
    }

    "사칙 연산 기호 중복일시 예외 테스트" {
        shouldThrow<IllegalArgumentException> {
            calculator.calculateString("* * * *")
        }
    }

    "사칙 연산 순서 이상하게 나올 경우 예외 테스트" {
        shouldThrow<IllegalArgumentException> {
            calculator.calculateString("1 1 1")
        }
        shouldThrow<IllegalArgumentException> {
            calculator.calculateString("1 * 1 1")
        }
        shouldThrow<IllegalArgumentException> {
            calculator.calculateString("1 1 * 1")
        }
        shouldThrow<IllegalArgumentException> {
            calculator.calculateString("* 1 * 1")
        }
        shouldThrow<IllegalArgumentException> {
            calculator.calculateString("1 * * 1")
        }
    }
})
