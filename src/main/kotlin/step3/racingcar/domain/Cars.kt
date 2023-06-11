package step3.racingcar.domain

import java.lang.IllegalArgumentException

class Cars(
    private val cars: List<Car>
) {
    init {
        validateEmptyCars(cars)
    }

    private fun validateEmptyCars(cars: List<Car>) {
        if (cars.isEmpty()) {
            throw IllegalArgumentException("자동차 대수는 한 대 이상이여야 합니다.")
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
