package car.domain.move

import kotlin.random.Random

class RandomMovableStrategy : MovableStrategy {
    override val movable: Boolean
        get() = Random.nextInt(MAXIMUM_MOVE_CONDITION) >= MINIMUM_REQUIRED_CONDITION

    companion object {
        private const val MINIMUM_REQUIRED_CONDITION = 4
        private const val MAXIMUM_MOVE_CONDITION = 10
    }
}
