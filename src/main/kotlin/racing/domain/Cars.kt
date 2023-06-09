package racing.domain

import racing.domain.strategy.MoveStrategy

class Cars(private val values: List<Car>) : Iterable<Car> {
    constructor(capacity: Capacity) : this(createCarList(capacity))

    fun notifyMoving(moveStrategy: MoveStrategy): Unit = values.forEach { it.move(strategy = moveStrategy) }

    fun <K, V> toMap(keyMapper: (Car) -> K, valueMapper: (Car) -> V): Map<K, V> =
        values.associateBy(keyMapper, valueMapper)

    override fun iterator(): Iterator<Car> = values.iterator()

    companion object {
        private fun createCarList(capacity: Capacity): List<Car> {
            require(capacity > Capacity.ZERO) { "Invalid Size: ${capacity.value} required 0 over size" }

            return capacity.map { Car(id = it) }
        }
    }
}
