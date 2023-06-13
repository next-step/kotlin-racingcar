package racingcar.domain.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class CarListTest : BehaviorSpec({

    Given("CarList") {
        When("carCount 5개일 때 ") {
            val carList = CarList.of(5)

            Then("cars == lineNumber 0~4인 Car 5개 리스트") {
                carList.cars.forEachIndexed { index, car -> car.lineNumber shouldBe index }
            }
        }

        When("carCount == 3, tryCount == 5일 때") {
            val carList = CarList.of(3)
            val racingRecord = carList.race(5)

            Then("racingRecord.size == carCount") {
                racingRecord.carRecords.size shouldBe carList.cars.size
            }

            Then("racingRecord.carRecords[0].records.size == tryCount") {
                racingRecord.carRecords.first().records.size shouldBe 5
            }
        }
    }
})
