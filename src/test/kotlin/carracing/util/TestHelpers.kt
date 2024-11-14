package carracing.util

import carracing.strategy.RandomGenerator

fun alwaysMoveGenerator(): RandomGenerator =
    object : RandomGenerator {
        override fun generate(): Int = 4
    }

fun neverMoveGenerator(): RandomGenerator =
    object : RandomGenerator {
        override fun generate(): Int = 3
    }
