package game.racingcar.strategy

import kotlin.random.Random

class RandomMoveStrategy : MoveStrategy {
    override fun move(current: Int): Int {
        return when (Random.nextInt(0, 10)) {
            in MOVABLE_RANGE -> current + MOVING_UNIT
            else -> current
        }
    }

    companion object {
        const val MOVING_UNIT = 1
        val MOVABLE_RANGE = 4 until 10
    }
}
