package racinggame

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racinggame.domain.DiceResult

class DiceResultTest : BehaviorSpec({

    Given("주사위가 던져졌다") {
        val diceResult = 4
        When("주사위가 4이상이 나온 경우") {
            val condition = DiceResult.getResult(diceResult)
            Then("앞으로 전진 상태가 되어야 한다") {
                condition shouldBe DiceResult.FORWARD
            }
        }
    }
})
