package racingcar.service

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.MoveFactor

class RacingGame(val cars: Cars) {
    fun play() {
        cars.move(MoveFactor.random)
    }

    fun winners(): Cars {
        return cars.carsInLead()
    }

    companion object {
        const val CAR_NAME_DELIMITER = ","
        private const val DEFAULT_NAME_PREFIX = "P"

        fun of(carCount: Int): RacingGame {
            val cars = List(carCount) { Car.of(DEFAULT_NAME_PREFIX + it) }
            return RacingGame(Cars(cars))
        }

        fun of(carNames: String): RacingGame {
            val cars = carNames.split(CAR_NAME_DELIMITER).map { Car.of(it) }
            return RacingGame(Cars(cars))
        }
    }
}
