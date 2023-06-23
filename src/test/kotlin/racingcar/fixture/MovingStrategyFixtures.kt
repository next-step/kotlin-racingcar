package racingcar.fixture

import racingcar.domain.movingstrategy.MovingStrategy

val ALWAYS_MOVING_STRATEGY = object : MovingStrategy {
    override fun isMovable(): Boolean {
        return true
    }
}

val NEVER_MOVING_STRATEGY = object : MovingStrategy {
    override fun isMovable(): Boolean {
        return false
    }
}
