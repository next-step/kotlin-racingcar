package racingcar.car

import racingcar.domain.strategy.MoveStrategy

class AlwaysFalseMoveStrategy : MoveStrategy {
    override fun isMovable(): Boolean {
        return false
    }
}
