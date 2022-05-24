package racingcar

import racingcar.model.MovingStrategy

class AlwaysStopStrategy : MovingStrategy {
    override fun forwardMovable(): Boolean {
        return false
    }
}
