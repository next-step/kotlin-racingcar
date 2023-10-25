package step2

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class OperatorBehaviorSpec : BehaviorSpec({

    Given("연산자가 주어진다") {
        When("연산자가 + 인 경우") {
            val op = Operator.getOperator("+")
            Then("덧셈을 한다") {
                op.applyAsInt(1, 2) shouldBe 3
            }
        }
        When("연산자가 - 인 경우") {
            val op = Operator.getOperator("-")
            Then("뺄셈을 한다") {
                op.applyAsInt(2, 1) shouldBe 1
            }
        }
        When("연산자가 * 인 경우") {
            val op = Operator.getOperator("*")
            Then("곱셈을 한다") {
                op.applyAsInt(1, 2) shouldBe 2
            }
        }
        When("연산자가 / 인 경우") {
            val op = Operator.getOperator("/")
            Then("나눗셈을 한다") {
                op.applyAsInt(4, 2) shouldBe 2
            }
        }
    }
})
