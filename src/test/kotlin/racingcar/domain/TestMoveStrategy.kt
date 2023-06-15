package racingcar.domain

import racingcar.domain.strategy.MoveStrategy

class TestMoveStrategy(val value: Boolean) : MoveStrategy {
    override fun move(): Boolean {
        return value
    }
}
