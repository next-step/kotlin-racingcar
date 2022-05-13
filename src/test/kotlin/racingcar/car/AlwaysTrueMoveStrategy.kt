package racingcar.car

import racingcar.car.strategy.MoveStrategy

class AlwaysTrueMoveStrategy : MoveStrategy {
    override fun isMovable(): Boolean {
        return true
    }
}
