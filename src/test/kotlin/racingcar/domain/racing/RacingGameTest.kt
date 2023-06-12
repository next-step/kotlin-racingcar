package racingcar.domain.racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.car.CarList

internal class RacingGameTest : BehaviorSpec({

    Given("RacingGame") {
        When("racingCondition.carCount = 3, tryCount = 5일 때") {
            val racingCondition = RacingCondition(3, 5)
            val racingGame = RacingGame(CarList.of(racingCondition.carCount), racingCondition)
            val racingRecord = racingGame.start()

            Then("start()의 반환값 RacingRecord.carRecords.size == carCount ") {
                racingRecord.carRecords.size shouldBe racingCondition.carCount
            }
        }
    }
})
