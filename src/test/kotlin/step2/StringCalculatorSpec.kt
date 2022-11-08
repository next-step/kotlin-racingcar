package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class StringCalculatorSpec : BehaviorSpec() {
    init {

        Given("문자열 계산기에") {
            val calculator = StringCalculator()

            When("입력값이 주어졌을 때에") {
                And("올바른 입력값이면") {
                    val argument1 = "2 + 3 * 4 / 2"
                    val argument2 = "33 / 3 * 3 + 2"

                    Then("계산된 값을 반환한다") {
                        calculator.execute(argument1) shouldBe 10
                        calculator.execute(argument2) shouldBe 35
                    }
                }

                And("유효하지 않은 입력값이면") {
                    val illegalArgument1 = ""
                    val illegalArgument2 = "1 = 1"
                    val illegalArgument3 = "a + b - c"

                    Then("예외를 던진다") {
                        shouldThrow<InvalidCalculatorInput> {
                            calculator.execute(illegalArgument1)
                            calculator.execute(illegalArgument2)
                            calculator.execute(illegalArgument3)
                        }
                    }
                }
            }
        }
    }
}
