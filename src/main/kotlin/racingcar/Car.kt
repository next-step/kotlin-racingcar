package racingcar

class Car {
    var position: Int = DEFAULT_POSITION
        private set

    fun move(movingStrategy: MovingStrategy = RandomMovingStrategy()) {
        if (movingStrategy.isMovable()) {
            position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION = 0
    }
}
