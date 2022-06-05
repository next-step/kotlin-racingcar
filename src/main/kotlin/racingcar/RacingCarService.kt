package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.MoveStrategy
import racingcar.domain.Over4MoveStrategy
import racingcar.service.RandomGenerator
import racingcar.view.response.GameResult

class RacingCarService(
    private val randomGenerator: RandomGenerator,
    private val moveStrategy: MoveStrategy = Over4MoveStrategy(randomGenerator),
) {

    fun playGame(carNames: List<String>, numberOfTries: Int): GameResult {
        val cars = initialize(carNames)
        val gameResult = GameResult()

        require(numberOfTries >= 1) { "시도 횟수는 1번 이상이어야 합니다" }

        for (i in 1..numberOfTries) {
            val repsResult = cars.play1Reps(moveStrategy)
            gameResult.addReps(repsResult)
        }

        val winners = cars.findWinners()
        gameResult.addWinners(winners.map { it.name })

        return gameResult
    }

    private fun initialize(carNames: List<String>): Cars {
        val cars = carNames.map { Car(it) }

        return Cars(cars)
    }
}
