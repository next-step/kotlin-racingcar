package racinggame.domain.player

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class UserUniqueIdTest : BehaviorSpec({

    Given("다수의 유저 아이디를 생성하면") {
        val actual = List(10) { UserUniqueId.create() }
        Then("버전이 순차 상승한다.") {
            val expected = actual.sortedBy { it.value }
            actual shouldBe expected
        }
    }
})
