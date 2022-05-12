package racingcar.domain

import kotlin.random.Random

private const val MIN_CARS_SIZE = 2

class RacingGame(
    private var cars: List<Car>,
    private val tryNumber: TryNumber,
) {
    init {
        require(cars.size >= MIN_CARS_SIZE)
    }

    fun play(): List<List<Car>> {
        val result = mutableListOf<List<Car>>()
        while (!tryNumber.isComplete()) {
            cars = cars.map { it.moveOrNot(Random.nextInt(0, 9)) }
                .also { result.add(it) }
            tryNumber.consume()
        }

        return result.toList()
    }
}
