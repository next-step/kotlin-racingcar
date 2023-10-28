package racinggame

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarConditionTest : BehaviorSpec({

    Given("주사위가 던져졌다") {
        val diceResult = 4
        When("주사위가 4이상이 나온 경우") {
            val condition = CarCondition.getCondition(diceResult)
            Then("앞으로 전진 상태가 되어야 한다") {
                condition shouldBe CarCondition.FORWARD
            }
        }
    }
})
