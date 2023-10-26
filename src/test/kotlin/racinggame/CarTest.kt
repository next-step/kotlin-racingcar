package racinggame

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({

    Given("자동차가 주어졌다") {
        val car = Car()
        When("앞으로 갈 경우") {
            val originPosition = car.position
            car.forward()
            Then("1칸 앞으로 이동 해야 한다") {
                car.position shouldBe originPosition + 1
            }
        }
    }
})
