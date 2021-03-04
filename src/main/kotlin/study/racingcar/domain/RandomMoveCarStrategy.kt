package study.racingcar.domain

import kotlin.random.Random

class RandomMoveCarStrategy : MoveStrategy {
    override fun isMoveCar(): Boolean {
        return Random.nextInt(9) >= MOVE_ALLOWABLE_VALUE
    }

    companion object {
        private const val MOVE_ALLOWABLE_VALUE = 4
    }
}
