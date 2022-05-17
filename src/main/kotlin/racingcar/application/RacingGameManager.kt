package racingcar.application

import racingcar.domain.Car
import racingcar.domain.Driver
import racingcar.domain.Race

object RacingGameManager {

    fun play(gameInput: GameInput, driver: Driver): GameResult {

        val race = gameInput.run {
            Race(enrollCars(names, driver), numberOfRaces)
        }

        val records = race.proceed()

        val winners = race.selectWinner()

        return GameResult(winners, records)
    }

    private fun enrollCars(names: List<String>, driver: Driver): List<Car> {
        require(names.isNotEmpty()) { "자동차 이름이 입력되지 않았습니다." }
        return names.map { Car(it, driver) }
    }
}
