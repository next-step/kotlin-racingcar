package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Name
import racingcar.domain.Race

class RaceTest : BehaviorSpec({
    Given("3개의 자동차 이름으로") {
        val names = listOf("pobi", "crong", "honux")
        When("레이스가 생성되면") {
            val race = Race.create(
                names.map { name ->
                    Name.of(name)
                }
            )
            Then("3개의 자동차가 생성된다.") {
                race.cars.size shouldBe 3
            }
        }
    }
})
