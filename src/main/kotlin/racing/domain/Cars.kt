package racing.domain

import racing.domain.strategy.MovableStrategy

class Cars(private val values: List<Car>) : List<Car> by values {
    constructor(capacity: Capacity) : this(createCarList(capacity))

    fun notifyMoving(movableStrategy: MovableStrategy): Unit = values.forEach { it.move(strategy = movableStrategy) }

    companion object {
        private fun createCarList(capacity: Capacity): List<Car> {
            require(capacity > Capacity.ZERO) { "Invalid Size: ${capacity.value} required 0 over size" }

            return capacity.map { Car(id = it) }
        }
    }
}
