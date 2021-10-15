package racingcar.domain

class Car(
    val position: Int = 0,
    private val movingStrategy: MovingStrategy = RandomMoveStrategy()
) {

    init {
        require(position >= 0)
    }

    fun moveForward(): Car {
        if (movingStrategy.canMove()) {
            return Car(position + 1)
        }
        return this
    }
}
