package racingcar.domain.game

import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.spyk
import io.mockk.verify
import racingcar.domain.car.Car
import racingcar.domain.configuration.CarRacingGameConfiguration
import racingcar.domain.configuration.CarRacingResultConfiguration
import racingcar.domain.result.CarRacingResult
import racingcar.domain.rule.RandomMoveRule
import racingcar.domain.rule.RandomNumberGeneratorInBound

class CarRacingGameTest : BehaviorSpec({
    Given("자동차 경주 게임이 생성되었을 때") {
        val cars = listOf(Car(0, 0), Car(0, 1))
        val roundCount = 2
        val roundRange = 1..roundCount
        val result = spyk(
            CarRacingResult.createInitialResult(
                CarRacingResultConfiguration(
                    cars = cars,
                    roundRange = roundRange,
                )
            )
        )
        val game = spyk(
            objToCopy = CarRacingGame.set(
                configuration = CarRacingGameConfiguration(
                    cars = cars,
                    roundRange = roundRange,
                ),
                result = result,
                moveRule = RandomMoveRule(RandomNumberGeneratorInBound(4..4))
            ),
            recordPrivateCalls = true,
        )
        When("게임을 실행하면") {
            game.run()
            Then("라운드 횟수만큼 라운드가 실행된다") {
                verify(exactly = roundCount) {
                    game["runRound"]()
                }
            }
            And("라운드 별로 경기 결과가 기록된다") {
                verify(exactly = 1) {
                    roundRange.forEach { roundNumber ->
                        result.record(roundNumber, any())
                    }
                }
            }
        }
    }
})
