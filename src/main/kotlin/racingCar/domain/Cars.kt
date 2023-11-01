package racingCar.domain

import racingCar.util.NumberGenerator

class Cars(
    val cars: List<Car>,
    private val numberGenerator: NumberGenerator
) {

    fun move() {
        cars.forEach {
            val power = numberGenerator.generate()
            it.move(power)
        }
    }
}
