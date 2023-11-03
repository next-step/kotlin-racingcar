package org.bmsk.racingcar.domain.model

import org.bmsk.racingcar.domain.policy.movement.MovementPolicy
import org.bmsk.racingcar.model.Position

data class Car(
    val movementPolicy: MovementPolicy,
    val name: String = "",
    val position: Position = Position(xPos = 0),
) {
    init {
        require(name.length <= CAR_NAME_LENGTH_CONSTRAINTS) { "이름은 5글자 이내이어야 합니다." }
    }

    fun move(): Car = copy(
        name = name,
        position = movementPolicy.move(position),
    )

    companion object {
        const val CAR_NAME_LENGTH_CONSTRAINTS = 5
    }
}
