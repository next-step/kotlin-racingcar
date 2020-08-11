package racingcar.domain

import kotlin.random.Random

class CarRandomMovementRule : CarMovementRule {
    override val rule: () -> Boolean = { Random.nextInt(RANDOM_BOUND_MAX) >= RANDOM_BOUND_MIN }

    companion object {
        private const val RANDOM_BOUND_MAX = 10
        private const val RANDOM_BOUND_MIN = 4
    }
}
