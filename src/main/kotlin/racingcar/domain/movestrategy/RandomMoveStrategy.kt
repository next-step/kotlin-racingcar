package racingcar.domain.movestrategy

import racingcar.domain.Number

class RandomMoveStrategy : MoveStrategy {

    override fun movable(): Boolean {
        return Number.random() >= MOVE_POINT
    }

    companion object {
        private val MOVE_POINT = Number.from(4)
    }
}
