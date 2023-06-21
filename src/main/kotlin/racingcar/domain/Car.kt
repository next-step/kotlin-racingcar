package racingcar.domain

import racingcar.domain.movingstrategy.MovingStrategy

class Car {
    var position: Int = DEFAULT_POSITION
        private set

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION = 0
    }
}
