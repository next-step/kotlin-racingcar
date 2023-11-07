package org.bmsk.effectivekotlin.domain.policy.movement

import org.bmsk.effectivekotlin.model.Position

sealed interface MovementPolicy {
    fun move(position: Position): Position

    interface RandomMovement : MovementPolicy
}
