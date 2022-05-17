package racingcar.application

import racingcar.domain.Car
import racingcar.domain.GameReferee
import racingcar.domain.Driver
import racingcar.domain.RacingCars
import racingcar.domain.RacingGame
import racingcar.domain.RandomDriver

object RacingGameManager {

    fun proceed(gameInput: GameInput, driver: Driver): GameResult {

        val racingGame = gameInput.run {
            RacingGame(numberOfRaces, enrollRacingCars(names, driver))
        }

        val gameRecord = racingGame.play()

        return GameReferee.rank(gameRecord)
    }

    private fun enrollRacingCars(names: List<String>, driver: Driver): RacingCars {
        require(names.isNotEmpty()) { "자동차 이름이 입력되지 않았습니다." }
        val cars = names.map { Car(it, RandomDriver) }
        return RacingCars(cars, driver)
    }
}
