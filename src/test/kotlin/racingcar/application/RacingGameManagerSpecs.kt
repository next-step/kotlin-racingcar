package racingcar.application

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RacingGameManagerSpecs : DescribeSpec({

    describe("경주 게임 관리자는") {
        context("주어진 입력이 유효하다면") {
            val numberOfCars = 3
            val numberOfRaces = 5
            val gameInput = GameInput(numberOfCars, numberOfRaces)
            it("게임을 진행하고 게임 결과를 반환한다") {
                val gameResult = RacingGameManager.proceed(gameInput)
                gameResult.also {
                    it.raceResults.size shouldBe numberOfRaces
                    it.raceResults.forEach { raceResult ->
                        raceResult.raceRecord.cars.size shouldBe numberOfCars
                    }
                }
            }
        }
        context("주어진 입력이 유효하지 않다면") {
            val numberOfCars = -1
            val numberOfRaces = -1
            val gameInput = GameInput(numberOfCars, numberOfRaces)
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    RacingGameManager.proceed(gameInput)
                }
            }
        }
    }
})
