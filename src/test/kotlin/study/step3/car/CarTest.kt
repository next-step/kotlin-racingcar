package study.step3.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({

    Given("Car 클래스가") {
        val car = Car()

        When("움직이지 않아야 할 경우") {
            car.move(false)

            Then("위치는 0이어야 한다") {
                car.getVisualPosition() shouldBe ""
            }
        }

        When("움직여야 할 경우") {
            car.move(true)

            Then("위치는 1이어야 한다") {
                car.getVisualPosition() shouldBe "-"
            }
        }
    }
})
