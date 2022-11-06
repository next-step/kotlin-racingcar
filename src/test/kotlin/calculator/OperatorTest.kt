package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe

class OperatorTest : BehaviorSpec({
    Given("연산자 기호가") {
        val validInputs = listOf("+", "-", "*", "/")
        When("사칙 연산자에 해당하는 기호이면") {
            Then("해당 Operator를 찾을 수 있다.") {
                validInputs.forAll {
                    Operator.symbolOf(it) shouldBeIn Operator.values()
                }
            }
        }

        val invalidInputs = listOf("!", "#", "$", "a", "0")
        When("사칙연산자 외의 기호이면") {
            Then("IllegalArgumentException 예외가 발생한다.") {
                invalidInputs.forAll {
                    shouldThrow<IllegalArgumentException> {
                        Operator.symbolOf(it)
                    }
                }
            }
        }
    }

    // 3 + 2 = 5
    val plusOperator = Operator.symbolOf("+")
    val plusAccumulation = 3
    val plusOperand = 2
    Given("더하기 연산자 기호이고 축적값이 3, 피연산자가 2일 때") {
        When("연산이 실행되면") {
            val result = plusOperator.operate(plusAccumulation, plusOperand)
            Then("결과값은 5이다.") {
                result shouldBe 5
            }
        }
    }

    // 5 - 2 = 3
    val minusOperator = Operator.symbolOf("-")
    val minusAccumulation = 5
    val minusOperand = 2
    Given("빼기 연산자 기호이고 축적값이 5, 피연산자가 2일 때") {
        When("연산이 실행되면") {
            val result = minusOperator.operate(minusAccumulation, minusOperand)
            Then("결과값은 3이다.") {
                result shouldBe 3
            }
        }
    }

    // 3 * 2 = 6
    val multiplyOperator = Operator.symbolOf("*")
    val multiplyAccumulation = 3
    val multiplyOperand = 2
    Given("곱하기 연산자 기호이고 축적값이 3, 피연산자가 2일 때") {
        When("연산이 실행되면") {
            val result = multiplyOperator.operate(multiplyAccumulation, multiplyOperand)
            Then("결과값은 6이다.") {
                result shouldBe 6
            }
        }
    }

    // 6 / 2 = 3
    val divideOperator = Operator.symbolOf("/")
    val divideAccumulation = 6
    val divideOperand = 2
    Given("나누기 연산자 기호이고 축적값이 6, 피연산자가 2일 때") {
        When("연산이 실행되면") {
            val result = divideOperator.operate(divideAccumulation, divideOperand)
            Then("결과값은 3이다.") {
                result shouldBe 3
            }
        }
    }

    // 6 / 0 -> throw ArithmeticException
    val divideZeroOperand = 0
    Given("나누기 연산자 기호이고 축적값이 6, 피연산자가 0일 때") {
        When("연산이 실행되면") {
            Then("ArithmeticException 예외가 발생한다.")
            shouldThrow<ArithmeticException> {
                divideOperator.operate(divideAccumulation, divideZeroOperand)
            }
        }
    }
})
