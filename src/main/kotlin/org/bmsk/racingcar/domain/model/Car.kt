package org.bmsk.racingcar.domain.model

import org.bmsk.racingcar.domain.policy.MovementPolicy
import org.bmsk.racingcar.model.Position

data class Car(
    val name: String = "",
    val position: Position = Position(xPos = 0),
    val movementPolicy: MovementPolicy = MovementPolicy.RandomMovement,
) {
    fun getTheMovedCar(): Car = this.copy(
        name = name,
        position = movementPolicy.move(position),
    )
}
