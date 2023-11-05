package racingcar.controller

import racingcar.domain.Car
import kotlin.random.Random

class CarController(
    private val cars: List<Car>,
) {

    fun race() {
        cars.forEach { car: Car -> car.move(random.nextInt(RANDOM_MAX_VALUE)) }
    }

    companion object {
        private const val RANDOM_MAX_VALUE = 10
        private val random = Random.Default
    }
}
