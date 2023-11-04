package org.bmsk.racingcar.domain.policy.movement

import org.bmsk.racingcar.model.Position

sealed interface MovementPolicy {
    fun move(position: Position): Position

    interface RandomMovement : MovementPolicy
}
