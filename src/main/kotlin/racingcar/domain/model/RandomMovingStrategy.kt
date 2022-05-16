package racingcar.domain.model

import kotlin.random.Random

class RandomMovingStrategy : MovingStrategy {
    override fun tryMove(): Boolean = getRandomNumber() >= FORWARD_NUMBER

    private fun getRandomNumber(): Int {
        return Random.nextInt(MAX_BOUND)
    }

    companion object {
        private const val FORWARD_NUMBER: Int = 4
        private const val MAX_BOUND: Int = 9
    }
}
