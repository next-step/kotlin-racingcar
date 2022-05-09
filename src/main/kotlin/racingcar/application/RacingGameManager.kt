package racingcar.application

import racingcar.domain.Car
import racingcar.domain.RacingCars
import racingcar.domain.RacingGame

object RacingGameManager {

    fun proceed(gameInput: GameInput): GameResult {
        val racingGame = gameInput.run {
            RacingGame(numberOfRaces, getParticipants(numberOfCars))
        }

        val racingPhaseRecords = racingGame.play()

        return GameResult(racingPhaseRecords)
    }

    private fun getParticipants(numberOfCars: Int): RacingCars {
        val cars = List(numberOfCars) { Car() }
        return RacingCars(cars)
    }
}
