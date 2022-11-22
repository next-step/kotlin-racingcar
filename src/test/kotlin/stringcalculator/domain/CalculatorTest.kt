package stringcalculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    "빈 수식을 계산하면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Calculator.calculate(emptyList())
        }
    }

    "올바르지 않은 수식으로 계산하면 예외가 발생한다" {
        val wrongFormula = listOf("1", "+", "2", "+")

        val exception = shouldThrow<IllegalArgumentException> {
            Calculator.calculate(wrongFormula)
        }
        exception.message shouldBe "숫자와 연산기호의 수가 올바르지 않습니다. 수식: $wrongFormula"
    }

    "숫자와 연산기호의 위치가 올바르지 않으면 예외가 발생한다" {
        val wrongFormula = listOf("1", "+", "+")

        shouldThrow<IllegalArgumentException> {
            Calculator.calculate(wrongFormula)
        }
    }

    "문자열 수식을 계산한다" {
        val formula = listOf("2", "+", "3", "*", "4", "/", "2")

        Calculator.calculate(formula) shouldBe 10
    }
})
