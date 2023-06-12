package calculator

import calculator.operation.OperationParser
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : BehaviorSpec({

    Given("BasicCalculator ") {
        val calculator = BasicCalculator()
        When("operation: 2 + 3 일 때") {
            val operation = OperationParser.parseOperation("2 + 3")
            Then("5 출력") {
                val result = BasicCalculator().calculate(operation)

                result.value shouldBe 5
            }
        }

        When("operation: 2 + 3 * 3 / 5 일 때") {
            val operation = OperationParser.parseOperation("2 + 3 * 3 / 5")

            Then("3 출력") {
                val result = BasicCalculator().calculate(operation)

                result.value shouldBe 3
            }
        }

        When("0으로 나누기 했을 때") {
            val operation = OperationParser.parseOperation("2 + 3 * 3 / 0")

            Then("ArithmeticException 발생") {
                val exception = shouldThrow<ArithmeticException> {
                    BasicCalculator().calculate(operation)
                }

                exception.message shouldBe "0으로 나눌 수 없습니다."
            }
        }
    }
})
