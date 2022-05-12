package step3.racingcar.car

import step3.racingcar.car.strategy.MoveStrategy

class AlwaysTrueMoveStrategy : MoveStrategy {
    override fun isMovable(): Boolean {
        return true
    }
}
