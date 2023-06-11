package racinggame.domain.player

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class RacerTest : BehaviorSpec({

    Given("레이서가 존재할 때") {
        val racer = Racer(id = "testId", ordinal = 0)
        When("레이서를 유저로 변환하면") {
            val user = racer.toUser()
            Then("변환된 유저는 레이서와 동일한 id를 갖는다") {
                user.id shouldBe racer.id
            }
        }
    }
})
