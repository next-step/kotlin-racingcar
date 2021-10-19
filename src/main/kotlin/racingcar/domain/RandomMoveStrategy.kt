package racingcar.domain

import kotlin.random.Random

class RandomMoveStrategy : MovingStrategy {
    override fun canMove(): Boolean {
        val randomNumber = Random.nextInt(10)
        return randomNumber > MINIMUM_MOVE_NUMBER
    }

    companion object {
        private const val MINIMUM_MOVE_NUMBER = 4
    }
}
