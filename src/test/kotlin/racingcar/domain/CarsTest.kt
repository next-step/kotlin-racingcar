package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe

class CarsTest : BehaviorSpec({

    given("자동차들을 움직인다.") {
        val carNames = "car1,car2,car3".split(",")
        val cars = Cars(carNames.map { Car(it) })
        `when`("자동차들을 조작한다.") {
            cars.operateCars()
            then("자동차들이 움직이거나 멈췄다.") {
                cars.cars.forEach { car ->
                    (0..1).contains(car.position) shouldBe true
                }
            }
        }

        `when`("우승자를 구한다.") {
            val winners = cars.isWinner()
            then("우승자가 존재한다.") {
                winners.size shouldBeGreaterThanOrEqual 1
            }
        }
    }
})
