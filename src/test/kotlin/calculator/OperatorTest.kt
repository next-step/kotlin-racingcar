package calculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class OperatorTest : BehaviorSpec({

    Given("정수인 두 개의 피연산자를") {
        val operand1 = 10
        val operand2 = 20

        When("더하기 연산을 한다면") {
            val add = Operator.of("+")(operand1, operand2)
            Then("두 정수를 더한 결과를 반환한다.") {
                add shouldBe 30
            }
        }

        When("빼기 연산을 한다면") {
            val sub = Operator.of("-")(operand1, operand2)
            Then("두 정수를 뺀 결과를 반환한다.") {
                sub shouldBe -10
            }
        }

        When("곱하기 연산을 한다면") {
            val multi = Operator.of("*")(operand1, operand2)
            Then("두 정수를 곱한 결과를 반환한다.") {
                multi shouldBe 200
            }
        }

        When("나누기 연산을 한다면") {
            val div = Operator.of("/")(operand2, operand1)
            Then("두 번째 피연산자로 첫 번째 피연산자를 나눈 결과를 반환한다.") {
                div shouldBe 2
            }
        }

        When("소수가 반환될 나누기 연산을 한다면") {
            val div = Operator.of("/")(operand1, operand2)
            Then("0을 반환한다.") {
                div shouldBe 0
            }
        }
    }

    Given("0과 정수인 피연산자 두 개를") {
        val operand1 = 10
        val operandZero = 0

        When("나누기 연산을 한다면") {
            val div = Operator.of("/")(operand1, operandZero)
            Then("null을 반환한다.") {
                div shouldBe null
            }
        }
    }
})
