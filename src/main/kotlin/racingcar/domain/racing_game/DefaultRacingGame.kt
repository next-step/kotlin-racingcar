package racingcar.domain.racing_game

import racingcar.domain.random.RandomGenerator
import racingcar.model.Car

class DefaultRacingGame(
    private val randomGenerator: RandomGenerator,
    cars: List<Car>
) : RacingGame {
    override var cars: List<Car> = cars.toList()
        private set

    override fun race() {
        cars = cars.map { car ->
            if (randomGenerator.getRandomValidation()) return@map car.goForward()
            car
        }
    }
}
