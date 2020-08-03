package racingcar.racing.rule

import kotlin.random.Random

class CarRandomMovementRule : CarMovementRule {
    override val rule: () -> Boolean = { Random.nextInt(RANDOM_BOUND_MAX) >= RANDOM_BOUND_MIN }

    companion object {
        const val RANDOM_BOUND_MAX = 10
        const val RANDOM_BOUND_MIN = 4
    }
}
