package racingcar.racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarRacingTest : StringSpec({

    val carRacing = CarRacing()

    "자동차 경주 테스트" {
        forAll(
            row(
                Car(Indicator(listOf(1, 2))),
                2,
                listOf(TurnRecord(1, listOf(0)), TurnRecord(2, listOf(0)))
            ),
            row(
                Car(Indicator(listOf(8, 9))),
                2,
                listOf(TurnRecord(1, listOf(1)), TurnRecord(2, listOf(2)))
            ),
            row(
                Car(Indicator(listOf(1, 9, 2))),
                3,
                listOf(TurnRecord(1, listOf(0)), TurnRecord(2, listOf(1)), TurnRecord(3, listOf(1)))
            )
        ) { car, turnCount, expectedRecord ->
            val result = carRacing.participate(listOf(car), turnCount)
            val actualRecord = result.getAll()
            actualRecord.forEachIndexed { index, turnRecord ->
                turnRecord.turn shouldBe expectedRecord[index].turn
                turnRecord.results shouldBe expectedRecord[index].results
            }
        }
    }
})
