package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RacingGameSpecs : DescribeSpec({

    describe("경주 게임은") {
        val numberOfPhase = 5
        val racingCars = RacingCars(
            listOf(
                Car(),
                Car(),
                Car()
            )
        )
        val race = RacingGame(
            numberOfPhase,
            racingCars
        )
        it("경주 수 만큼 경기를 진행하고 경주 결과를 반환한다") {
            val raceRecords = race.play()
            with(raceRecords) {
                size shouldBe numberOfPhase
            }
        }
    }
})
