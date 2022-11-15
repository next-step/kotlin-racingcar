package racingcar.domain.racing_game

import racingcar.model.Car
import racingcar.model.Owner

class CompeteRacingGame(private val racingGame: RacingGame) : Winner, RacingGame by racingGame {
    override fun getWinner(): List<String> {
        val cars = racingGame.cars
        val maxDistance = getMaxDistance(cars)
        return cars.filter { it.track.length == maxDistance }.map { car ->
            check(car is Owner)
            car.name
        }
    }

    private fun getMaxDistance(cars: List<Car>): Int = cars.maxOf { it.track.length }
}
