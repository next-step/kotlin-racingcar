package racingcar.model

data class Car(
    val id: Int,
    val position: Int = DEFAULT_POSITION,
    private val movingStrategy: MovingStrategy
) {

    fun moveForward(): Car {
        return when (movingStrategy.forwardMovable()) {
            true -> forward()
            false -> stop()
        }
    }

    private fun forward() = Car(id = id, position = position + 1, movingStrategy = movingStrategy)

    private fun stop() = Car(id = id, position = position, movingStrategy = movingStrategy)

    companion object {
        private const val DEFAULT_POSITION = 0
        internal const val MAX_BOUND = 10
    }
}
