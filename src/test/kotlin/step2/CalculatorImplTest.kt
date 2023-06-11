package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorImplTest : StringSpec({
    val calculatorImpl = CalculatorImpl()
    "덧셈 테스트" {
        calculatorImpl.plus(1, 2) shouldBe 3
    }

    "뺄셈 테스트" {
        calculatorImpl.minus(1, 2) shouldBe -1
    }

    "곱셉 테스트" {
        calculatorImpl.multiply(1, 2) shouldBe 2
    }

    "나눗셈 테스트" {
        calculatorImpl.divide(4, 2) shouldBe 2
    }

    "사칙연산 기호가 아닌 테스트" {
        shouldThrow<IllegalArgumentException> {
            calculatorImpl.checkSymbol("$")
        }
    }

    "기본 사칙연산 테스트" {
        calculatorImpl.calculate(1, "+", 2) shouldBe 3
    }

    "입력값 공백과 null 테스트" {
        shouldThrow<IllegalArgumentException> {
            calculatorImpl.calculateString("")
        }
        shouldThrow<IllegalArgumentException> {
            calculatorImpl.calculateString(" ")
        }
        shouldThrow<IllegalArgumentException> {
            calculatorImpl.calculateString(null)
        }
    }

    "사칙 연산 예제 테스트" {
        calculatorImpl.calculateString("2 + 3 * 4 / 2") shouldBe 10
    }

    "사칙 연산 기호 중복일시 예외 테스트" {
        shouldThrow<IllegalArgumentException> {
            calculatorImpl.calculateString("* * * *")
        }
    }

    "사칙 연산 순서 이상하게 나올 경우 예외 테스트" {
        shouldThrow<IllegalArgumentException> {
            calculatorImpl.calculateString("1 1 1")
        }
        shouldThrow<IllegalArgumentException> {
            calculatorImpl.calculateString("1 * 1 1")
        }
        shouldThrow<IllegalArgumentException> {
            calculatorImpl.calculateString("1 1 * 1")
        }
        shouldThrow<IllegalArgumentException> {
            calculatorImpl.calculateString("* 1 * 1")
        }
        shouldThrow<IllegalArgumentException> {
            calculatorImpl.calculateString("1 * * 1")
        }
    }
})
