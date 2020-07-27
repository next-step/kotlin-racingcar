package racingcar.model

import racingcar.strategy.MovingStrategy

data class Car(
    private val id: Int,
    private val movingStrategy: MovingStrategy
) {
    private var position = 0

    fun getName() = "$NAME_TITLE$id"

    fun getMovingPath() = PATH_SYMBOL.repeat(position)

    fun moveForward() {
        if (movingStrategy.isMovable) {
            position += MOVING_DISTANCE
        }
    }

    companion object {
        private const val NAME_TITLE = "No."
        private const val MOVING_DISTANCE = 1
        private const val PATH_SYMBOL = "-"
    }
}
