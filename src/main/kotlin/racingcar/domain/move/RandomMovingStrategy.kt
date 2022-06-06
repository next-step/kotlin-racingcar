package racingcar.domain.move

import kotlin.random.Random

private val RANDOM_NUMBER_BOUND = 0..9
private const val MOVING_THRESHOLD = 4

class RandomMovingStrategy : MovingStrategy {
    override fun canMove(): Boolean {
        return RANDOM_NUMBER_BOUND.random() >= MOVING_THRESHOLD
    }
}
