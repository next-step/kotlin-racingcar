package racing.model

import racing.model.move.MoveStrategy

data class Car(
    val name: Name,
    val position: Int,
) {

    fun move(moveStrategy: MoveStrategy): Car {
        if (moveStrategy.movable()) {
            return Car(name, position + VELOCITY)
        }
        return this
    }

    companion object {
        private const val VELOCITY = 1
    }
}
