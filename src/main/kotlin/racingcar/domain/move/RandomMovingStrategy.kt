package racingcar.domain.move

import kotlin.random.Random

private const val RANDOM_NUMBER_BOUND = 10
private const val MOVING_THRESHOLD = 4

class RandomMovingStrategy : MovingStrategy {
    override fun canMove(): Boolean {
        return Random.nextInt(RANDOM_NUMBER_BOUND) >= MOVING_THRESHOLD
    }
}
