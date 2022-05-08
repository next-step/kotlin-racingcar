package racingcar

import kotlin.random.Random

class RandomStrategy : MovingStrategy {

    override fun isMovable(): Boolean {
        val number = generateRandomNumber()
        return number >= MOVABLE_MIN_CONDITION
    }

    private fun generateRandomNumber(): Int {
        return Random.nextInt(MOVING_CONDITION_MIN, MOVING_CONDITION_MAX)
    }

    companion object {
        private const val MOVING_CONDITION_MIN = 0
        private const val MOVING_CONDITION_MAX = 9
        private const val MOVABLE_MIN_CONDITION = 4
    }
}
