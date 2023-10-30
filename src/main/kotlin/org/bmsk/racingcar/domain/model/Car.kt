package org.bmsk.racingcar.domain.model

import org.bmsk.racingcar.domain.policy.movement.MovementPolicy
import org.bmsk.racingcar.model.Position

data class Car(
    val movementPolicy: MovementPolicy,
    val name: String = "",
    val position: Position = Position(xPos = 0),
) {
    fun getMovedCar(): Car = this.copy(
        name = name,
        position = movementPolicy.move(position),
    )
}
