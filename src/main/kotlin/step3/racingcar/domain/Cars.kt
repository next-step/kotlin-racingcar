package step3.racingcar.domain

import step3.racingcar.view.Messages
import java.lang.IllegalArgumentException

class Cars(
    private val cars: List<Car>
) {
    init {
        validateEmptyCars(cars)
    }

    private fun validateEmptyCars(cars: List<Car>) {
        if (cars.isEmpty()) {
            throw IllegalArgumentException(Messages.MESSAGE_CONDITION_CAR_COUNT)
        }
    }

    fun move() {
        cars.forEach(Car::move)
    }

    fun getPosition() {
        cars.forEach { car ->
            println("-".repeat(car.position))
        }
    }
}
