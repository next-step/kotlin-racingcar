package racingcar.model

data class Car(
    val name: CarName,
    val position: Int = DEFAULT_POSITION,
    private val movingStrategy: MovingStrategy
) {

    fun moveForward(): Car {
        return when (movingStrategy.forwardMovable()) {
            true -> forward()
            false -> stop()
        }
    }

    private fun forward() = copy(position = position + 1)

    private fun stop() = copy()

    companion object {
        private const val DEFAULT_POSITION = 0
        internal const val MAX_BOUND = 10
    }
}
