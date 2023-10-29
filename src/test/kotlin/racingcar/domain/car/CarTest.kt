package racingcar.domain.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
    Given("자동차가 주어졌을 때") {
        val car = Car()

        When("특정 양만큼 자동차를 이동시키면") {
            car.move(2)

            Then("자동차의 위치가 바뀐다") {
                car.position shouldBe 2
            }
        }
    }
})
