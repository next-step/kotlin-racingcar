package carRacing.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
    Given("자동차가 생성된다.") {
        val car = Car()
        When("경기 규칙에 의해 race 를 성공 했을 때") {
            car.tryRace { true }
            Then("현재 위치는 1이 된다") {
                car.curPosition shouldBe 1
            }
        }
        When("경기 규칙에 의해 race 를 실패 했을 때") {
            car.tryRace { false }
            Then("현재 위치는 그대로 1이 된다") {
                car.curPosition shouldBe 1
            }
        }
    }
})
