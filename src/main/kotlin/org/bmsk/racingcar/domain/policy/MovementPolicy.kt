package org.bmsk.racingcar.domain.policy

import org.bmsk.racingcar.model.Position

sealed interface MovementPolicy {
    fun move(position: Position): Position

    interface RandomMovement : MovementPolicy
}
