package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe

class OperatorTest : BehaviorSpec({
    Given("사용자가 계산기를 사용할 때") {
        When("사칙연산자 기호를 입력하면") {
            val validInputs = listOf("+", "-", "*", "/")
            Then("기호를 통해 해당 Operator를 찾을 수 있다.") {
                validInputs.forAll {
                    Operator.symbolOf(it) shouldBeIn Operator.values()
                }
            }
        }

        When("사칙연산자 이외의 기호를 입력하면") {
            val invalidInputs = listOf("!", "#", "$", "a", "0")
            Then("IllegalArgumentException 예외가 발생한다.") {
                invalidInputs.forAll {
                    shouldThrow<IllegalArgumentException> {
                        Operator.symbolOf(it)
                    }
                }
            }
        }

        // 3 + 2 = 5
        When("축적값과 더하기 연산자, 피연산자가 들어오면") {
            val accumulation = 3
            val operator = Operator.symbolOf("+")
            val operand = 2
            Then("축적값에 피연산자가 더해진다.") {
                operator.operate(accumulation, operand) shouldBe 5
            }
        }

        // 5 - 2 = 3
        When("축적값과 빼기 연산자, 피연산자가 들어오면") {
            val accumulation = 5
            val operator = Operator.symbolOf("-")
            val operand = 2
            Then("축적값에 피연산자가 빼진다.") {
                operator.operate(accumulation, operand) shouldBe 3
            }
        }

        // 3 * 2 = 6
        When("축적값과 곱하기 연산자, 피연산자가 들어오면") {
            val accumulation = 3
            val operator = Operator.symbolOf("*")
            val operand = 2
            Then("축적값에 피연산자가 곱해진다.") {
                operator.operate(accumulation, operand) shouldBe 6
            }
        }

        // 6 / 2 = 3
        When("축적값과 나누기 연산자, 피연산자가 들어오면") {
            val accumulation = 6
            val operator = Operator.symbolOf("/")
            val operand = 2
            Then("축적값에 피연산자가 나눠진다.") {
                operator.operate(accumulation, operand) shouldBe 3
            }
        }
    }
})
