package racingcar.domain.racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import racingcar.domain.car.CarList

internal class RacingGameTest : BehaviorSpec({

    Given("RacingGame") {
        val carList = CarList.of("1, 2, 3, 4, 5")
        When("CarList.size = 5, tryCount = 5일 때") {
            val racingCondition = RacingCondition(5)
            val racingGame = RacingGame(carList, racingCondition)
            racingGame.start()

            Then("반환값 RacingRecord.carRecords[].carRecord.record.size == tryCount ") {
                racingGame.carList.cars.forAll { car ->
                    car.carRecord.record.size shouldBe racingCondition.tryCount
                }
            }
        }
    }
})
