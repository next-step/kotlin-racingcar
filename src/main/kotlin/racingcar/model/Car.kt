package racingcar.model

class Car(
    val id: Int,
    var position: Int = DEFAULT_POSITION
) {

    fun moveForward(movingStrategy: MovingStrategy) {
        if (movingStrategy.forwardMovable()) {
            this.position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION = 0
        internal const val MAX_BOUND = 10
    }
}
