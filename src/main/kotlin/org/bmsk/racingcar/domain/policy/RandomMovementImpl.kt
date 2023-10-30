package org.bmsk.racingcar.domain.policy

import org.bmsk.racingcar.domain.random.RandomGenerator
import org.bmsk.racingcar.domain.random.ZeroToNineRandomGenerator
import org.bmsk.racingcar.model.Position

class RandomMovementImpl(
    private val randomGenerator: RandomGenerator = ZeroToNineRandomGenerator()
) : MovementPolicy.RandomMovement {

    override fun move(position: Position): Position {
        val distance = randomGenerator.generate()
        return if (distance >= DISTANCE_CONDITIONS) {
            position.copy(xPos = position.xPos + 1)
        } else {
            position
        }
    }

    companion object {
        private const val DISTANCE_CONDITIONS = 4
    }
}
