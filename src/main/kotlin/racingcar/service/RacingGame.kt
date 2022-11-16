package racingcar.service

import racingcar.model.Car
import racingcar.model.MoveFactor

class RacingGame(val cars: List<Car>) {
    fun play() {
        cars.forEach { it.move(MoveFactor.random()) }
    }

    fun winners(): List<Car> {
        val winnerPosition = cars.maxOf { car -> car.position.value }
        return cars.filter { car -> car.position.value == winnerPosition }
    }

    companion object {
        const val CAR_NAME_DELIMITER = ","
        private const val DEFAULT_NAME_PREFIX = "P"

        fun of(carCount: Int): RacingGame {
            val cars = List(carCount) { Car(DEFAULT_NAME_PREFIX + it) }
            return RacingGame(cars)
        }

        fun of(carNames: String): RacingGame {
            return RacingGame(carNames.split(CAR_NAME_DELIMITER).map { Car(it) })
        }
    }
}
