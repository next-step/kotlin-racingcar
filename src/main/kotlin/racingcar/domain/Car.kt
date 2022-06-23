package racingcar.domain

import racingcar.domain.moving.MoveStrategy

class Car(
    val position: Int = 0,
) {
    fun move(moveStrategy: MoveStrategy): Car {
        return if (moveStrategy.isMovable())
            Car(position + FORWARD)
        else
            this
    }

    companion object {
        const val FORWARD = 1
    }
}
