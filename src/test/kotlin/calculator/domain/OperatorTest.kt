package calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class OperatorTest : BehaviorSpec({

    Given("사칙 연산 기호가 주어질 경우") {
        When("+ 이면") {
            Then("덧셈 결과를 반환한다.") {
                val result = Operator.calculate(10, "+", 2)
                result shouldBe 12
            }
        }

        When("- 이면") {
            Then("뺄셈 결과를 반환한다.") {
                val result = Operator.calculate(10, "-", 2)
                result shouldBe 8
            }
        }

        When("* 이면") {
            Then("곱셈 결과를 반환한다.") {
                val result = Operator.calculate(10, "*", 2)
                result shouldBe 20
            }
        }

        When("/ 이면") {
            Then("나눗셈 결과를 반환한다.") {
                val result = Operator.calculate(10, "/", 2)
                result shouldBe 5
            }
        }

        When("사칙 연산 기호가 아니면") {
            Then("IllegalArgumentException가 발생한다.") {
                listOf("!", "@", "#", "$", "%", "^", "&").forAll { invalidOperator ->
                    shouldThrow<IllegalArgumentException> {
                        Operator.calculate(10, invalidOperator, 2)
                    }
                }
            }
        }
    }
})
