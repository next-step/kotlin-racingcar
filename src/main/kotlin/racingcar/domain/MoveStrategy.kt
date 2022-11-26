package racingcar.domain

import kotlin.random.Random

fun interface MoveStrategy {
    fun canMove(): Boolean
}

class RandomStrategy : MoveStrategy {
    override fun canMove(): Boolean = Random.nextInt(MAX_RANDOM_THRESHOLD) >= MIN_MOVE_CONDITION

    companion object {
        private const val MAX_RANDOM_THRESHOLD = 10
        private const val MIN_MOVE_CONDITION = 4
    }
}
