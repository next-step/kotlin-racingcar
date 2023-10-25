package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    "사칙연산 테스트" {
        val calculator = Calculator("2 + 3 * 4 / 2")
        val result = calculator.calculate()
        result shouldBe 10
    }

    "0이 포함된 사칙연산 테스트" {
        val calculator = Calculator("0 + 0 * 0 / 2")
        val result = calculator.calculate()
        result shouldBe 0
    }

    "음수가 포함된 사칙연산 테스트" {
        val calculator = Calculator("2 + 3 * -4 / 2")
        val result = calculator.calculate()
        result shouldBe -10
    }

    "한가지 연산자만 포함된 사칙연산 테스트" {
        val calculator = Calculator("2 + 4 + 10")
        val result = calculator.calculate()
        result shouldBe 16
    }

    "수식에 숫자말고 다른 문자가 포함된 경우 테스트" {
        val calculator = Calculator("2 + 3 * 4 / 2 + a")
        shouldThrow<IllegalArgumentException> {
            calculator.calculate()
        }
    }
})