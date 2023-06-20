package racingcar

import racingcar.movingstrategy.DefaultMovingStrategy
import racingcar.movingstrategy.MovingStrategy

class Car {
    var position: Int = DEFAULT_POSITION
        private set

    fun move(movingStrategy: MovingStrategy = DefaultMovingStrategy()) {
        if (movingStrategy.isMovable()) {
            position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION = 0
    }
}
