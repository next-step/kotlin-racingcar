package racingcar.domain

import racingcar.util.NumberGenerator

data class Cars(
    private val numberGenerator: NumberGenerator,
    private val carCount: Int
) : Iterable<Car> {
    private val cars = Array(carCount) { Car(numberGenerator) }

    fun moveAll() {
        cars.forEach { it.move() }
    }

    override fun iterator(): Iterator<Car> =
        cars.iterator()
}
