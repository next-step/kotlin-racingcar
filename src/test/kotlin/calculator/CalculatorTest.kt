package calculator

import calculator.exception.NoSymbolException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : BehaviorSpec({

    Given("BasicCalculator ") {
        val calculator = BasicCalculator()
        When("operation: 2 + 3 일 때") {
            Then("5 출력") {
                val result = BasicCalculator().calculate("2 + 3")

                result shouldBe 5
            }
        }

        When("operation: 2 + 3 * 3 / 5 일 때") {
            Then("3 출력") {
                val result = BasicCalculator().calculate("2 + 3 * 3 / 5")

                result shouldBe 3
            }
        }

        When("0으로 나누기 했을 때") {
            Then("ArithmeticException 발생") {
                val exception = shouldThrow<ArithmeticException> {
                    BasicCalculator().calculate("2 + 3 * 3 / 0")
                }

                exception.message shouldBe "0으로 나눌 수 없습니다."
            }
        }

        When("사칙연산 외의 연산을 수행했을 때") {
            Then("NoSymbolException 발생") {
                val exception = shouldThrow<NoSymbolException> {
                    BasicCalculator().calculate("2 ++ 3")
                }

                exception.message shouldBe "허용되지 않는 연산 기호입니다."
            }
        }
    }
})
