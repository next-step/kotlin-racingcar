package racing.domain

import racing.domain.strategy.MovableStrategy

class Cars(private val values: Set<Car>) : Set<Car> by values {
    constructor(capacity: Capacity) : this(createCarList(capacity))
    constructor(names: String) : this(createCarList(names))

    fun notifyMoving(movableStrategy: MovableStrategy): Unit = values.forEach { it.move(strategy = movableStrategy) }

    companion object {
        private const val DELIMITER = ","

        private fun createCarList(names: String): Set<Car> {
            val splitNames = names.split(DELIMITER)
            val result = splitNames.distinct()
                .map { it.trim() }
                .mapIndexed { idx, name ->
                Car(id = idx, name = Name(name))
            }.toSet()

            require( splitNames.size == result.size ) {
                "자동차 이름은 중복될 수 없습니다."
            }

            return result
        }

        private fun createCarList(capacity: Capacity): Set<Car> {
            require(capacity > Capacity.ZERO) { "Invalid Size: ${capacity.value} required 0 over size" }

            return capacity.map { Car(id = it) }.toSet()
        }
    }
}
