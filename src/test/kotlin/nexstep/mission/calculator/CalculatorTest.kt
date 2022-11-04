package nexstep.mission.calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({

    context("계산기") {
        test("문자열 리스트로 수식을 받으면 순차적으로 계산한다.") {
            // "2+3*6/3"
            val expression = listOf("2", "+", "3", "*", "6", "/", "3")
            val result = Calculator.calculate(expression = expression)
            result shouldBe 10
        }
    }
})
