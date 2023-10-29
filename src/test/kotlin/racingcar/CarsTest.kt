package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarsTest : BehaviorSpec({
    given("자동차들을 움직인다.") {
        val carNames = "car1,car2,car3".split(",")
        val cars = Cars(carNames)
        `when`("자동차들을 조작한다.") {
            cars.operateCars()
            then("자동차들이 움직이거나 멈췄다.") {
                cars.carList.forEach { car ->
                    (0..1).contains(car.position) shouldBe true
                }
            }
        }
    }
})
