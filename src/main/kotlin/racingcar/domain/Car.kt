package racingcar.domain

/**
 * 자동차.
 */
data class Car(
    val position: Position = Position(0),
    private val movingStrategy: MovingStrategy = RandomMoveStrategy()
) {

    fun moveForward(): Car {
        if (movingStrategy.canMove()) {
            return Car(position.move(1))
        }
        return this
    }

    /**
     * 위치를 전달한다.
     */
    fun getPosition(): Int {
        return position.value
    }
}
