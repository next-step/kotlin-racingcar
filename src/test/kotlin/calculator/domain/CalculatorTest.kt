package calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class CalculatorTest : BehaviorSpec({
    Given("수식이 주어졌는데") {
        var expression = "2 + 3 * 4 / 2".split(" ").toMutableList()
        When("올바른 수식일 경우") {
            Then("결과값을 반환한다.") {
                val result = Calculator.calculate(expression)
                result shouldBe 10
            }
        }

        expression = "+ 3 * 4 / 2".split(" ").toMutableList()
        When("올바른 수식이 아닐 경우") {
            Then("예외가 발생한다.") {
                shouldThrow<NumberFormatException> {
                    Calculator.calculate(expression)
                }
            }
        }
    }
})
