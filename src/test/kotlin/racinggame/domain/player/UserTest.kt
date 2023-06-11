package racinggame.domain.player

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class UserTest : BehaviorSpec({
    Given("유저가 존재할 때") {
        val user = User(id = "testId")
        When("유저를 레이서로 변환하면") {
            val racer = user.toRacer(ordinal = 0)
            Then("변환된 레이서는 유저와 동일한 id를 갖는다") {
                racer.id shouldBe user.id
            }
        }
    }
})
