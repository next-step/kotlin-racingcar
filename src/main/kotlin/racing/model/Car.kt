package racing.model

import racing.model.move.MoveStrategy

data class Car(
    val name: String,
    val position: Int,
) {
    private val velocity = 1
    fun move(moveStrategy: MoveStrategy): Car {
        if (moveStrategy.movable()) {
            return Car(name, position + velocity)
        }
        return this
    }
}
