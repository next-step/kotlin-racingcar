package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.dto.CarInfo
import racingcar.dto.GameResult
import racingcar.dto.Record

internal class GameResultTest : BehaviorSpec({
    Given("경기 결과가 주어지면, ") {
        val given = GameResult(
            mutableListOf(
                Record(
                    listOf(
                        CarInfo(name = "car1", position = 1),
                        CarInfo(name = "car2", position = 2),
                        CarInfo(name = "car3", position = 3)
                    )
                ),
                Record(
                    listOf(
                        CarInfo(name = "car1", position = 4),
                        CarInfo(name = "car2", position = 5),
                        CarInfo(name = "car3", position = 6)
                    )
                )
            )
        )
        When("마지막 결과를 뽑아오는 메서드를 호출하면, ") {
            val result = given.getLastRoundRecord()
            Then("마지막 결과를 가져온다.") {
                result shouldBe Record(
                    listOf(
                        CarInfo(name = "car1", position = 4),
                        CarInfo(name = "car2", position = 5),
                        CarInfo(name = "car3", position = 6)
                    )
                )
            }
        }
    }
})
