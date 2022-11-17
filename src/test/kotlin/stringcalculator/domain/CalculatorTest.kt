package stringcalculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import stringcalculator.domain.Calculator.ADD
import stringcalculator.domain.Calculator.DIVIDE
import stringcalculator.domain.Calculator.MULTIPLY
import stringcalculator.domain.Calculator.SUBTRACT

class CalculatorTest : StringSpec({

    "사칙연산 기호로 해당하는 계산기를 찾는다" {
        listOf(
            "+" to ADD,
            "-" to SUBTRACT,
            "*" to MULTIPLY,
            "/" to DIVIDE
        ).forEach { (sign, calculator) ->
            Calculator.of(sign) shouldBe calculator
        }
    }

    "올바르지 않는 기호로 계산기를 찾으면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Calculator.of("a")
        }
    }

    "두 개의 숫자로 연산을 수행한다" {
        listOf(
            ADD to 4,
            SUBTRACT to 0,
            MULTIPLY to 4,
            DIVIDE to 1
        ).forEach { (calculator, expected) ->
            calculator.calculate(2, 2) shouldBe expected
        }
    }

    "0으로 나누면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            DIVIDE.calculate(2, 0)
        }
    }
})
