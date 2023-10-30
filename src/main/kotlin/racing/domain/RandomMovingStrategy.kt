package racing.domain

import kotlin.random.Random

class RandomMovingStrategy : MovingStrategy {

    companion object {
        private const val RANDOM_BOUND = 9
        private const val TARGET_NUMBER = 4
    }

    override fun isMovable(): Boolean {
        return Random.nextInt(RANDOM_BOUND) >= TARGET_NUMBER
    }
}
