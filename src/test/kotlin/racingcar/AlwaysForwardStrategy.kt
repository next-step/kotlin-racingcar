package racingcar

import racingcar.model.MovingStrategy

class AlwaysForwardStrategy : MovingStrategy {
    override fun forwardMovable(): Boolean {
        return true
    }
}
