package racingcar.model

import racingcar.strategy.MovingStrategy

data class Car(
    private val id: Int,
    private val name: String,
    private val movingStrategy: MovingStrategy
) : Comparable<Car> {
    var position = 0
        private set

    fun getName() = "$NAME_TITLE$id $name"

    fun getMovingPath() = PATH_SYMBOL.repeat(position)

    fun moveForward() {
        if (movingStrategy.isMovable) {
            position += MOVING_DISTANCE
        }
    }

    fun isWinner(maxPosition: Int): Boolean = position >= maxPosition

    override fun compareTo(other: Car): Int = position.compareTo(other.position)

    companion object {
        private const val NAME_TITLE = "No."
        private const val MOVING_DISTANCE = 1
        private const val PATH_SYMBOL = "-"
    }
}
