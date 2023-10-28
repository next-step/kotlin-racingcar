package racinggame

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({

    Given("자동차가 주어졌다") {
        val car = Car()
        When("앞으로 가야할 경우") {
            val originPosition = car.position
            car.move(4)
            Then("1칸 앞으로 이동 해야 한다") {
                car.position shouldBe originPosition + 1
            }
        }
    }
})
