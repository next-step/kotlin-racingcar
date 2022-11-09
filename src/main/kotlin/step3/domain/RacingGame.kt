package step3.domain

import step3.model.Car

class RacingGame(
    private val randomGenerator: RandomGenerator,
    cars: List<Car>
) {
    private val _cars: List<Car> = cars.toList().map { it.copy() }
    val cars: List<Car> get() = _cars.map { it.copy() }

    fun race() = _cars.forEach {
        if (randomGenerator.getRandomValidation()) it.goForward()
    }
}
