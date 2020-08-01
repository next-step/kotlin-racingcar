package racingcar.domain

import racingcar.strategy.Strategy

class RacingCars(
    private val carNames: List<String>,
    private val strategy: Strategy
) {
    private val cars = carNames.map { Car(it, strategy) }

    internal fun moveForwardAll() {
        cars.forEach {
            it.moveForward()
        }
    }

    internal fun getWinner() = cars.filter {
        it.isWinner(findMax(cars))
    }

    override fun toString() = cars.joinToString("")

    private fun findMax(cars: List<Car>) = cars.maxBy { it.currentPosition }?.currentPosition ?: 0
}
