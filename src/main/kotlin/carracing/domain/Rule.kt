package carracing.domain

import kotlin.random.Random

private const val LOWER_MOVING_FACTOR = 0
private const val UPPER_MOVING_FACTOR = 9

sealed class Rule {
    abstract fun generateMovingFactor(): Int

    class RandomRule : Rule() {
        override fun generateMovingFactor(): Int = Random.nextInt(until = UPPER_MOVING_FACTOR + 1)
    }

    class AlwaysMoveRule : Rule() {
        override fun generateMovingFactor(): Int = UPPER_MOVING_FACTOR
    }

    class NoMoveRule : Rule() {
        override fun generateMovingFactor(): Int = LOWER_MOVING_FACTOR
    }
}
