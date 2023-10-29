package racing.model

import racing.model.move.MoveStrategy

data class Car(
    val id: Int,
    val position: Int,
) {
    fun start(moveStrategy: MoveStrategy): Car {
        if (moveStrategy.movable()) {
            return Car(id, position + 1)
        }
        return this
    }
}
