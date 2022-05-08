package racingcar.application

import racingcar.domain.Car
import racingcar.domain.RacingCars
import racingcar.domain.RacingGame

object RacingGameManager {

    fun play(gameInput: GameInput): GameResult {
        val racingGame = gameInput.run {
            RacingGame(numberOfPhase, getParticipants(numberOfCars))
        }
        val racingRecords = racingGame.proceed()
        return GameResult(racingRecords)
    }

    private fun getParticipants(numberOfCars: Int): RacingCars {
        val cars = IntRange(1, numberOfCars).map { Car() }
        return RacingCars(cars)
    }
}
