package racingcar.application

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.RandomMovementCommandGenerator

class RacingGameManagerSpecs : DescribeSpec({

    describe("경주 게임 관리자는") {
        context("주어진 입력이 유효하다면") {
            val numberOfCars = 3
            val numberOfRaces = 5
            val gameInput = GameInput(numberOfCars, numberOfRaces)
            it("게임을 진행하고 게임 결과를 반환한다") {
                val gameResult = RacingGameManager.proceed(gameInput, RandomMovementCommandGenerator)
                gameResult.raceResults.size shouldBe numberOfRaces
                gameResult.raceResults.forEach { raceResult ->
                    raceResult.raceRecord.cars.size shouldBe numberOfCars
                }
            }
        }
        context("주어진 자동차의 대수가 유효하지 않다면") {
            val numberOfCars = -1
            val numberOfRaces = 5
            val gameInput = GameInput(numberOfCars, numberOfRaces)
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    RacingGameManager.proceed(gameInput, RandomMovementCommandGenerator)
                }
            }
        }

        context("주어진 경주 횟수가 유효하지 않다면") {
            val numberOfCars = 3
            val numberOfRaces = -1
            val gameInput = GameInput(numberOfCars, numberOfRaces)
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    RacingGameManager.proceed(gameInput, RandomMovementCommandGenerator)
                }
            }
        }
    }
})
