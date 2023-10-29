package racing.model

import racing.model.move.MoveStrategy

data class Car(
    val id: Int,
    val position: Int,
) {
    private val velocity = 1
    fun start(moveStrategy: MoveStrategy): Car {
        if (moveStrategy.movable()) {
            return Car(id, position + velocity)
        }
        return this
    }
}
