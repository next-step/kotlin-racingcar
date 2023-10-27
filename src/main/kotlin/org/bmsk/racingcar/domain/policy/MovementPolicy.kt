package org.bmsk.racingcar.domain.policy

import org.bmsk.racingcar.domain.random.DefaultRandomGenerator
import org.bmsk.racingcar.domain.random.RandomGenerator
import org.bmsk.racingcar.model.Position

sealed interface MovementPolicy {
    fun move(position: Position): Position

    class RandomMovement(private val randomGenerator: RandomGenerator = DefaultRandomGenerator()) : MovementPolicy {

        override fun move(position: Position): Position {
            val distance = randomGenerator.generate()
            return if (distance >= 4) {
                position.copy(xPos = position.xPos + 1)
            } else {
                position
            }
        }
    }
}
