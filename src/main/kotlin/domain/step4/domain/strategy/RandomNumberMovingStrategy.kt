package domain.step4.domain.strategy

import kotlin.random.Random

object RandomNumberMovingStrategy : MovingStrategy {
    private const val MOVING_ACCEPT_STANDARD = 4

    override fun movable() = Random.nextInt() >= MOVING_ACCEPT_STANDARD
}
