package racingcar.domain.strategy

import kotlin.random.Random

private const val RANDOM_UNTIL = 10

object RandomMovingStrategy : MovingStrategy {
    override fun isMovable() = Random.nextInt(RANDOM_UNTIL) >= MOVING_CRITERIA
}
