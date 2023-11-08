package carracing.domain

import kotlin.random.Random

sealed class Rule {
    abstract fun generateMovingFactor(): Int

    class RandomRule : Rule() {
        override fun generateMovingFactor(): Int = Random.nextInt(10)
    }

    class AlwaysMoveRule : Rule() {
        override fun generateMovingFactor(): Int = 9
    }

    class NoMoveRule : Rule() {
        override fun generateMovingFactor(): Int = 0
    }
}
