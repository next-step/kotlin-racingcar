package racing.model

import racing.model.move.MoveStrategy

class Car(
    val id: Int,
    val position: Int,
) {
    fun start(moveStrategy: MoveStrategy): Car {
        if (moveStrategy.goNext()) {
            return Car(id, position + 1)
        }
        return Car(id, position)
    }
}
