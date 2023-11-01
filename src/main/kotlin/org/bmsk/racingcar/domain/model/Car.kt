package org.bmsk.racingcar.domain.model

import org.bmsk.racingcar.domain.policy.movement.MovementPolicy
import org.bmsk.racingcar.model.Position

data class Car(
    val movementPolicy: MovementPolicy,
    val name: String = "",
    val position: Position = Position(xPos = 0),
) {
    init { require(name.length <= 5) { "이름은 5글자 이내이어야 합니다."} }

    fun getMovedCar(): Car = this.copy(
        name = name,
        position = movementPolicy.move(position),
    )
}
