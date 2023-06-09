package study

import Car
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeInRange

class CarBehaviorTest : BehaviorSpec({
    Given("자동차가") {
        val car = Car()
        When("랜덤 데이터를 받았을 때") {
            val randomInt = car.getRandomInt()
            Then("데이터는 0~9여야 한다") {
                randomInt shouldBeInRange 0..9

            }
        }
    }
})
