package racingcar.domain

import java.util.Random

object RandomMoveStrategy : MoveStrategy {
    private val random = Random()
    private const val MOVE_LOWER_BOUND = 4
    private const val RANDOM_UPPER_BOUND = 9

    override fun isMovable(): Boolean {
        return random.nextInt(RANDOM_UPPER_BOUND) >= MOVE_LOWER_BOUND
    }
}
