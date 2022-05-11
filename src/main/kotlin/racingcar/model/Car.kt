package racingcar.model

class Car(
    val id: Int,
    val position: Int = DEFAULT_POSITION
) {

    fun moveForward(movingStrategy: MovingStrategy): Car {
        return when (movingStrategy.forwardMovable()) {
            true -> Car(id = id, position = position + 1)
            false -> Car(id = id, position = position)
        }
    }

    companion object {
        private const val DEFAULT_POSITION = 0
        internal const val MAX_BOUND = 10
    }
}
