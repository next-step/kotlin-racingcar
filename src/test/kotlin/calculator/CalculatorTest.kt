package calculator

import calculator.Calculator.calculate
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CalculatorTest : BehaviorSpec({
    Given("사용자가 계산기를 사용할 때") {
        When("입력값이 null이거나 빈 공백 문자를 입력하면") {
            val invalidInputs = listOf(null, "", " ")
            Then("IllegalArgumentException 예외가 발생한다.") {
                invalidInputs.forAll {
                    shouldThrow<IllegalArgumentException> {
                        calculate(it)
                    }
                }
            }
        }

        When("수식을 입력하면") {
            val expressions = listOf(
                "2 + 3 * 4 / 2" to 10,
                "3 * 2 - 3 + 4" to 7,
                "10 / 2 + 3 * 2" to 16
            )
            Then("결과값을 출력한다.") {
                expressions.forAll { (expression, result) ->
                    calculate(expression) shouldBe result
                }
            }
        }
    }
})
