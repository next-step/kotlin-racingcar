package racingcar.racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class CarRacingTest : StringSpec({

    val mockIndicatorGenerator = mockk<IndicatorGenerator>()

    "자동차 경주 테스트" {
        forAll(
            row(
                listOf(TurnIndicator(listOf(1)), TurnIndicator(listOf(2))),
                listOf(Car()),
                2,
                listOf(TurnRecord(1, listOf(0)), TurnRecord(2, listOf(0)))
            ),
            row(
                listOf(TurnIndicator(listOf(8)), TurnIndicator(listOf(9))),
                listOf(Car()),
                2,
                listOf(TurnRecord(1, listOf(1)), TurnRecord(2, listOf(2)))
            ),
            row(
                listOf(TurnIndicator(listOf(3)), TurnIndicator(listOf(4)), TurnIndicator(listOf(2))),
                listOf(Car()),
                3,
                listOf(TurnRecord(1, listOf(0)), TurnRecord(2, listOf(1)), TurnRecord(3, listOf(1)))
            )
        ) { turnIndicators, cars, turnCount, expectedRecord ->

            every { mockIndicatorGenerator.generate(any(), any()) } returns turnIndicators

            val carRacing = CarRacing(mockIndicatorGenerator, turnCount, cars)

            carRacing.start()
            val result = carRacing.result()
            val actualRecord = result.getAll()
            actualRecord.forEachIndexed { index, turnRecord ->
                turnRecord.turn shouldBe expectedRecord[index].turn
                turnRecord.results shouldBe expectedRecord[index].results
            }
        }
    }
})
