package racingcar.application

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe
import racingcar.domain.PreparedDriver
import racingcar.domain.RandomDriver

class RacingGameManagerSpecs : DescribeSpec({

    val movementsWithOneWinner = listOf(
        3, 4, 3,
        1, 4, 6,
        0, 7, 0,
    )

    val movementsWithThreeWinners = listOf(
        8, 4, 6,
        8, 4, 6,
        8, 4, 6,
    )

    describe("경주 게임 관리자는") {
        context("주어진 입력이 유효하다면") {
            val names = listOf("car1", "car2", "car3")
            val numberOfRaces = 3
            val gameInput = GameInput(names, numberOfRaces)
            it("게임을 진행하고 게임 결과를 반환한다(case: 우승자 1명)") {
                val movementsGenerator = PreparedDriver(movementsWithOneWinner)
                val gameResult = RacingGameManager.proceed(gameInput, movementsGenerator)
                gameResult.also {
                    it.raceResults.size shouldBe numberOfRaces
                    it.raceResults.forEach { raceResult ->
                        raceResult.raceRecord.cars.size shouldBe names.size
                    }
                    it.winners shouldContainInOrder listOf("car2")
                }
            }
            it("게임을 진행하고 게임 결과를 반환한다(case: 우승자 여러명)") {
                val movementsGenerator = PreparedDriver(movementsWithThreeWinners)
                val gameResult = RacingGameManager.proceed(gameInput, movementsGenerator)
                gameResult.also {
                    it.raceResults.size shouldBe numberOfRaces
                    it.raceResults.forEach { raceResult ->
                        raceResult.raceRecord.cars.size shouldBe names.size
                    }
                    it.winners shouldContainInOrder names
                }
            }
        }

        context("주어진 자동차의 이름 수가 비어있다면") {
            val numberOfCars = emptyList<String>()
            val numberOfRaces = 5
            val gameInput = GameInput(numberOfCars, numberOfRaces)
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    RacingGameManager.proceed(gameInput, RandomDriver)
                }
            }
        }

        context("주어진 경주 횟수가 유효하지 않다면") {
            val names = listOf("k5", "g80", "sm5")
            val numberOfRaces = -1
            val gameInput = GameInput(names, numberOfRaces)
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    RacingGameManager.proceed(gameInput, RandomDriver)
                }
            }
        }
    }
})
