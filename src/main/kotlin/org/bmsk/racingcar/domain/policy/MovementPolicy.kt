package org.bmsk.racingcar.domain.policy

import org.bmsk.racingcar.model.Position

sealed interface MovementPolicy {
    fun move(position: Position): Position

    object RandomMovement : MovementPolicy {
        override fun move(position: Position): Position {
            val distance = (0..9).random()
            return if (distance >= 4) {
                position.copy(xPos = position.xPos + 1)
            } else {
                position
            }
        }
    }
}
