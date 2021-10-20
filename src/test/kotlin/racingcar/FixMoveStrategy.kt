package racingcar

import racingcar.domain.MovingStrategy

class FixMoveStrategy : MovingStrategy {
    override fun ableMove(): Boolean {
        return true
    }
}
