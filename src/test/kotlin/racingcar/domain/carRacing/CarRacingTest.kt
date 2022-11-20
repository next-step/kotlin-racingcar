package racingcar.domain.carRacing

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import racingcar.domain.carIndicator.IndicatorGenerator
import racingcar.domain.carIndicator.TurnIndicator

class CarRacingTest : StringSpec({

    val mockIndicatorGenerator = mockk<IndicatorGenerator>()

    "자동차 경주 결과 테스트" {
        forAll(
            row(
                listOf(TurnIndicator(listOf(1)), TurnIndicator(listOf(2))),
                listOf(Car("A")),
                2,
                listOf(
                    TurnRecord(1, listOf(CarRecord(Car("A"), 0))),
                    TurnRecord(2, listOf(CarRecord(Car("A"), 0)))
                )
            ),
            row(
                listOf(TurnIndicator(listOf(8)), TurnIndicator(listOf(9))),
                listOf(Car("B")),
                2,
                listOf(
                    TurnRecord(1, listOf(CarRecord(Car("B"), 1))),
                    TurnRecord(2, listOf(CarRecord(Car("B"), 2)))
                )
            ),
            row(
                listOf(TurnIndicator(listOf(3)), TurnIndicator(listOf(4)), TurnIndicator(listOf(2))),
                listOf(Car("C")),
                3,
                listOf(
                    TurnRecord(1, listOf(CarRecord(Car("C"), 0))),
                    TurnRecord(2, listOf(CarRecord(Car("C"), 1))),
                    TurnRecord(3, listOf(CarRecord(Car("C"), 1)))
                )
            )
        ) { turnIndicators, cars, turnCount, expectedRecord ->

            every { mockIndicatorGenerator.generate(any(), any()) } returns turnIndicators

            val carRacing = CarRacing(cars)

            carRacing.start(mockIndicatorGenerator, turnCount)
            val result = carRacing.result()
            val actualRecord = result.records
            actualRecord.forEachIndexed { index, turnRecord ->
                turnRecord.turn shouldBe expectedRecord[index].turn
                turnRecord.results shouldBe expectedRecord[index].results
            }
        }
    }

    "자동차 경주 우승자 테스트" {
        forAll(
            row(
                listOf(Car("A"), Car("B")),
                listOf(TurnIndicator(listOf(4, 9))),
                listOf(Car("A"), Car("B")),
            ),
            row(
                listOf(Car("A"), Car("B")),
                listOf(TurnIndicator(listOf(3, 9))),
                listOf(Car("B"))
            ),
            row(
                listOf(Car("A"), Car("B")),
                listOf(TurnIndicator(listOf(4, 1))),
                listOf(Car("A"))
            )
        ) { cars, turnIndicators, expectedWinners ->
            every { mockIndicatorGenerator.generate(any(), any()) } returns turnIndicators
            val carRacing = CarRacing(cars)
            carRacing.start(mockIndicatorGenerator, 1)
            val result = carRacing.result()
            result.winners shouldBe expectedWinners
        }
    }
})
