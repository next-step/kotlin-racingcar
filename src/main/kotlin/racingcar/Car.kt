package racingcar

class Car(
    val id: Int,
    var position: Int = DEFAULT_POSITION
) {

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            this.position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION = 0
        internal const val MAX_BOUND = 10
    }
}
