package racingCarWinner.domain.strategy

import racingCarWinner.domain.MoveStrategy

object AlwaysMoveStrategy : MoveStrategy {
    override fun isMovable(): Boolean {
        return true
    }
}
