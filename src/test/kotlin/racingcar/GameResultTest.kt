package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.dto.CarRecord
import racingcar.dto.GameResult
import racingcar.dto.Record

internal class GameResultTest : BehaviorSpec({
    Given("경기 결과가 주어지면, ") {
        val given = GameResult(
            listOf(
                Record(
                    listOf(
                        CarRecord(name = "car1", position = 1),
                        CarRecord(name = "car2", position = 2),
                        CarRecord(name = "car3", position = 3)
                    )
                ),
                Record(
                    listOf(
                        CarRecord(name = "car1", position = 4),
                        CarRecord(name = "car2", position = 5),
                        CarRecord(name = "car3", position = 6)
                    )
                )
            )
        )
        When("마지막 결과를 뽑아오는 메서드를 호출하면, ") {
            val result = given.getLastRoundRecord()
            Then("마지막 결과를 가져온다.") {
                result shouldBe Record(
                    listOf(
                        CarRecord(name = "car1", position = 4),
                        CarRecord(name = "car2", position = 5),
                        CarRecord(name = "car3", position = 6)
                    )
                )
            }
        }
    }
})
