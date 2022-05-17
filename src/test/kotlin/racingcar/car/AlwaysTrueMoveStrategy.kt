package racingcar.car

import racingcar.domain.MoveStrategy

class AlwaysTrueMoveStrategy : MoveStrategy {
    override fun isMovable(): Boolean {
        return true
    }
}
