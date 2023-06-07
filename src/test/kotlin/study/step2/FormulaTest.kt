import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import study.step2.Formula

class FormulaTest : BehaviorSpec({
    Given("Null 이 주어졌을 때") {
        When("객체를 생성할 때") {
            Then("예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    Formula(null)
                }.message shouldBe "잘못된 연산식입니다."
            }
        }
    }

    Given("공백 문자열이 주어졌을 때") {
        When("객체를 생성할 때") {
            Then("예외를 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    Formula(" ")
                }.message shouldBe "잘못된 연산식입니다."
            }
        }
    }

    Given("정상적인 식이 주어졌을 때") {
        val input = "2 + 3 * 4 / 2"
        When("객체를 생성할 때") {
            val formula = Formula(input)
            Then("정상적으로 생성된다.") {
                formula.expression shouldBe listOf("2", "+", "3", "*", "4", "/", "2")
            }
        }
    }
})
