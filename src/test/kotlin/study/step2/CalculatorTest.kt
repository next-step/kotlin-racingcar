package study.step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class CalculatorTest : BehaviorSpec({

    Given("계산기가 주어졌을 때") {
        val calculator = Calculator()

        When("덧셈 연산을 수행하면") {
            val result = calculator.add(5, 3)
            Then("결과는 두 숫자의 합이어야 한다") {
                result shouldBe 8
            }
        }

        When("뺄셈 연산을 수행하면") {
            val result = calculator.subtract(5, 3)
            Then("결과는 첫 번째 숫자에서 두 번째 숫자를 뺀 값이어야 한다") {
                result shouldBe 2
            }
        }

        When("곱셈 연산을 수행하면") {
            val result = calculator.multiply(5, 3)
            Then("결과는 두 숫자의 곱이어야 한다") {
                result shouldBe 15
            }
        }

        When("나눗셈 연산을 수행하면") {
            val result = calculator.divide(6, 3)
            Then("결과는 첫 번째 숫자를 두 번째 숫자로 나눈 값이어야 한다") {
                result shouldBe 2
            }
        }

        When("0으로 나누려고 하면") {
            Then("IllegalArgumentException 예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> { calculator.divide(6, 0) }
            }
        }

        When("문자열 수식이 제공되면") {
            val expression = "2 + 3 * 4 / 2"
            Then("결과는 연산자 우선순위가 아닌 입력 순서에 따라 계산되어야 한다") {
                val result = calculator.calculate(expression)
                result shouldBe 10
            }
        }
    }
})
