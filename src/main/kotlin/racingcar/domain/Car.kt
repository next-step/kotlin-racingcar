package racingcar.domain

import racingcar.domain.movingstrategy.MovingStrategy

class Car(private val movingStrategy: MovingStrategy) {
    var position: Int = DEFAULT_POSITION
        private set

    fun move() {
        if (movingStrategy.isMovable()) {
            position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION = 0
    }
}
