package racingcar.application

import racingcar.domain.Car
import racingcar.domain.MovementCommandGenerator
import racingcar.domain.RacingCars
import racingcar.domain.RacingGame

object RacingGameManager {

    fun proceed(gameInput: GameInput, movementCommandGenerator: MovementCommandGenerator): GameResult {

        val racingGame = gameInput.run {
            RacingGame(numberOfRaces, enrollRacingCars(numberOfCars), movementCommandGenerator)
        }

        val gameRecord = racingGame.play()

        return GameResult.of(gameRecord)
    }

    private fun enrollRacingCars(numberOfCars: Int): RacingCars {
        val cars = List(numberOfCars) { Car() }
        return RacingCars(cars)
    }
}
