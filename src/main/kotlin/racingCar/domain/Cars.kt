package racingCar.domain

import racingCar.util.NumberGenerator

class Cars(
    private val cars: List<Car>,
    private val numberGenerator: NumberGenerator
) {

    fun move() {
        cars.forEach {
            val power = numberGenerator.generate()
            it.move(power)
        }
    }

    fun getPositions(): List<CarPosition> {
        return cars.map {
            it.position
        }
    }
}
