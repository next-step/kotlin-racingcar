package racingcar.domain.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class CarListTest : BehaviorSpec({

    Given("CarList") {
        When("carCount 5개일 때 ") {
            val carList = CarList.of(5)

            Then("cars == lineNumber 0~4인 Car 5개 리스트") {
                carList.cars.size shouldBe 5
            }
        }

        When("carCount == 3, tryCount == 5일 때") {
            val carList = CarList.of(3)
            carList.race(5)
            Then("모든 Car가 race() 실행") {
                carList.cars.forEach { car ->
                    car.carRecord.record.size shouldBe 5
                }
            }
        }
    }
})
