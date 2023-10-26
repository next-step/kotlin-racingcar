package calculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CalculatorBddTest: BehaviorSpec({
    Given("계산기가 제공된다") {
        val calculator = Calculator()

        When("계산기에 null을 입력한다") {
            calculator.input(null)
            Then("IllegalArgumentException throw가 발생하는지 확인한다") {
                calculator.calculate()
            }
        }

        When("계산기에 빈 문자열을 입력한다") {
            calculator.input(" ")
            Then("IllegalArgumentException throw가 발생하는지 확인한다") {
                calculator.calculate()
            }
        }

        When("계산기에 \"2 + 3 * 4 / 2\" 문자열을 입력한다") {
            calculator.input("2 + 3 * 4 / 2")
            Then("계산기로 계산을 시작해 계산된 값 10이 나오는지 확인한다") {
                calculator.calculate() shouldBe 10
            }
        }

        When("계산기에 \"10 + 10 / 2 * 9\" 문자열을 입력한다") {
            calculator.input("10 + 10 / 2 * 9")
            Then("계산기로 계산을 시작해 계산된 값 90이 나오는지 확인한다") {
                calculator.calculate() shouldBe 90
            }
        }
    }
})