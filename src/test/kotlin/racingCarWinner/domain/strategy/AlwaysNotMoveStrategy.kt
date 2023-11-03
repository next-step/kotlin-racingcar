package racingCarWinner.domain.strategy

import racingCarWinner.domain.MoveStrategy

object AlwaysNotMoveStrategy : MoveStrategy {
    override fun isMovable(): Boolean {
        return false
    }
}
