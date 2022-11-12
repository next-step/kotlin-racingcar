package study.calculator

import calculator.Calculator
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class CalculatorTest : StringSpec({
    val calculator = Calculator()

    "덧셈" {
        val result = calculator.calculate("2 + 3 + 5")
        result shouldBe 10
    }

    "뺄셈" {
        val result = calculator.calculate("5 - 3 - 1")
        result shouldBe 1
    }

    "곱셈" {
        val result = calculator.calculate("5 * 2 * 3")
        result shouldBe 30
    }

    "나눗셈" {
        val result = calculator.calculate("20 / 2 / 5")
        result shouldBe 2
    }

    "입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            calculator.calculate("")
        }
    }

    "사칙연산 기호가 아닌 경우 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            calculator.calculate("3 % 3 $ 1")
        }
    }

    "사칙 연산을 모두 포함하는 기능 구현" {
        val result = calculator.calculate("2 + 3 * 4 / 2")
        result shouldBe 10
    }
})
