package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RacingGameSpecs : DescribeSpec({

    describe("경주 게임은") {
        context("경주 수가 유효하면") {
            val numberOfRaces = 5
            val racingCars = RacingCars(
                List(numberOfRaces) { Car() }
            )
            val racingGame = RacingGame(
                numberOfRaces,
                racingCars,
            )
            it("경주 수 만큼 경기를 진행하고 경주 결과를 반환한다") {
                val raceRecords = racingGame.play()
                raceRecords.also {
                    it.raceRecords.size shouldBe numberOfRaces
                }
            }
        }
        context("경주 수가 유효하지 않다면") {
            val invalidNumberOfRaces = -1
            val racingCars = RacingCars(
                listOf(Car())
            )
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    RacingGame(invalidNumberOfRaces, racingCars)
                }
            }
        }
    }
})
