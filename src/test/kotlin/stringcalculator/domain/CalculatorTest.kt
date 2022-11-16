package stringcalculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    "사칙연산 기호로 해당하는 계산기를 찾는다" {
        Calculator.of("+") shouldBe Calculator.ADD
    }

    "올바르지 않는 기호로 계산기를 찾으면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Calculator.of("a")
        }
    }
})
