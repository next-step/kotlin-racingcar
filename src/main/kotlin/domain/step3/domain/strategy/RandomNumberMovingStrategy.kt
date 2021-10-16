package domain.step3.domain.strategy

import kotlin.random.Random

object RandomNumberMovingStrategy : MovingStrategy {
    private const val STANDARD = 4

    override fun movable() = Random.nextInt() >= STANDARD
}
