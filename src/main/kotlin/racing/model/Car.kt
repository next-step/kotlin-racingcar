package racing.model

import racing.model.move.MoveStrategy

data class Car(
    val id: Int,
    val position: Int,
) {
    private val velocity = 1
    fun move(moveStrategy: MoveStrategy): Car {
        if (moveStrategy.movable()) {
            return Car(id, position + velocity)
        }
        return this
    }

    companion object {
        fun listOf(capacity: Int): List<Car> {
            return (1..capacity)
                .map { Car(it, 0) }
        }
    }
}
