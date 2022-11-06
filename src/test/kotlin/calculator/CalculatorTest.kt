package calculator

import calculator.Calculator.calculate
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CalculatorTest : BehaviorSpec({
    val invalidInputs = listOf(null, "", " ")
    Given("null 또는 빈 공백 문자가") {
        When("계산기에 입력되면") {
            Then("IllegalArgumentException 예외가 발생한다.") {
                invalidInputs.forAll {
                    shouldThrow<IllegalArgumentException> {
                        calculate(it)
                    }
                }
            }
        }
    }

    val validExpressions = listOf(
        "2 + 3 * 4 / 2" to 10,
        "3 * 2 - 3 + 4" to 7,
        "10 / 2 + 3 * 2" to 16
    )
    Given("유효한 수식이") {
        When("계산기에 입력되면") {
            Then("결과값을 출력한다.") {
                validExpressions.forAll { (expression, result) ->
                    calculate(expression) shouldBe result
                }
            }
        }
    }

    val invalidExpressions = listOf(
        "+ 3 * 4 / 2",
        "3 * 2 -",
        "10 / 2 + *"
    )
    Given("유효하지 않은 수식이") {
        When("계산기에 입력되면") {
            Then("예외가 발생한다.") {
                invalidExpressions.forAll {
                    shouldThrow<IllegalArgumentException> {
                        calculate(it)
                    }
                }
            }
        }
    }
})
