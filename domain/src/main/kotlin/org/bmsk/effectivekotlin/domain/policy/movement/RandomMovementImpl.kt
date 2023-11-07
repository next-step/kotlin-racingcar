package org.bmsk.effectivekotlin.domain.policy.movement

import org.bmsk.effectivekotlin.domain.random.RandomGenerator
import org.bmsk.effectivekotlin.domain.random.ZeroToNineRandomGenerator
import org.bmsk.effectivekotlin.model.Position

class RandomMovementImpl(
    private val randomGenerator: RandomGenerator = ZeroToNineRandomGenerator(),
) : MovementPolicy.RandomMovement {

    override fun move(position: Position): Position {
        val distance = randomGenerator.generate()
        return if (distance >= DISTANCE_CONDITIONS) {
            Position(xPos = position.xPos + 1)
        } else {
            position
        }
    }

    companion object {
        private const val DISTANCE_CONDITIONS = 4
    }
}
