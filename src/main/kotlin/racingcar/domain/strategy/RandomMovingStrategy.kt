package racingcar.domain.strategy

import kotlin.random.Random

class RandomMovingStrategy : MovingStrategy {
    override fun movable(): Boolean = Random.nextInt(MAX_RANDOM_RANGE) >= MOVE_CONSTRAINTS

    companion object {
        private const val MAX_RANDOM_RANGE = 10
    }
}
