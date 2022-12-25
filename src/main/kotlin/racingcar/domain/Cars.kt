package racingcar.domain

import racingcar.domain.strategy.MovableStrategy

data class Cars(private val cars: List<Car>) {
    fun move(movableStrategy: MovableStrategy) = cars.map { it.move(movableStrategy) }

    fun record() = copy(cars = cars.map { it.copy() })

    fun getSize() = cars.size

    fun getMaxPositionCars(): List<Car> {
        val maxPosition = cars.maxOf { it.position }

        return cars.filter { it.position == maxPosition }
    }

    override fun toString(): String {
        return cars.joinToString(separator = "\n") { "${it.name}: ${"-".repeat(it.position)}" }
    }
}
