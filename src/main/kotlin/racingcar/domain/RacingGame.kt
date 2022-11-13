package racingcar.domain

import racingcar.model.Car

class RacingGame(
    private val randomGenerator: RandomGenerator,
    cars: List<Car>
) {
    var cars: List<Car> = cars.toList()
        private set

    fun race() {
        cars = cars.map { car ->
            if (randomGenerator.getRandomValidation()) return@map car.goForward()
            car
        }
    }
}
