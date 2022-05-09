package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RacingGameSpecs : DescribeSpec({

    describe("경주 게임은") {
        val numberOfRaces = 5
        val racingCars = RacingCars(
            List(numberOfRaces) { Car() }
        )
        val racingGame = RacingGame(
            numberOfRaces,
            racingCars
        )
        it("경주 수 만큼 경기를 진행하고 경주 결과를 반환한다") {
            val raceRecords = racingGame.play()
            raceRecords.also {
                it.raceRecords.size shouldBe numberOfRaces
            }
        }
    }
})
