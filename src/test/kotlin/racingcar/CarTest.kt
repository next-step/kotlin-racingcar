package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeIn
import racingcar.domain.Car

class CarTest : BehaviorSpec({

    val car = Car()
    val initialDistance = car.distance
    Given("자동차가") {
        When("액션을 취하면") {
            car.takeAction()
            Then("주행 거리가 그대로이거나 1 증가한다.") {
                car.distance shouldBeIn listOf(initialDistance, initialDistance + 1)
            }
        }
    }
})
