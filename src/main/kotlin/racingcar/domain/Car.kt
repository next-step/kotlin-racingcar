package racingcar.domain

/**
 * 자동차.
 */
data class Car(
    val name: Name,
    val position: Position = Position(0),
    private val movingStrategy: MovingStrategy = RandomMoveStrategy()
) {

    fun moveForward(): Car {
        if (movingStrategy.canMove()) {
            return Car(name, position.move(1))
        }
        return this
    }

    /**
     * 위치를 전달한다.
     */
    fun getPosition(): Int {
        return position.value
    }

    fun findMaxPosition(comparePosition: Int): Int {
        return position.getMaxPosition(comparePosition)
    }

    fun isMaxPosition(maxPosition: Int): Boolean {
        return position.isMaxPosition(maxPosition)
    }
}
