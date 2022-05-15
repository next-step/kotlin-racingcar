package racingcar.application

import racingcar.domain.Car
import racingcar.domain.GameReferee
import racingcar.domain.MovementCommandGenerator
import racingcar.domain.RacingCars
import racingcar.domain.RacingGame

object RacingGameManager {

    fun proceed(gameInput: GameInput, movementCommandGenerator: MovementCommandGenerator): GameResult {

        val racingGame = gameInput.run {
            RacingGame(numberOfRaces, enrollRacingCars(names, movementCommandGenerator))
        }

        val gameRecord = racingGame.play()

        return GameReferee.rank(gameRecord)
    }

    private fun enrollRacingCars(names: List<String>, movementCommandGenerator: MovementCommandGenerator): RacingCars {
        require(names.isNotEmpty()) { "자동차 이름이 입력되지 않았습니다." }
        val cars = names.map { Car(it) }
        return RacingCars(cars, movementCommandGenerator)
    }
}
