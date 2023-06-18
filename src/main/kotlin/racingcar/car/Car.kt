package racingcar.car

class Car(private val moveStrategy: MoveStrategy) {

    private var position: Position = Position(DEFAULT_POSITION_VALUE)

    fun move() {
        if (moveStrategy.movable) {
            moveForward()
        }
    }

    fun getPosition(): Int {
        return position.getPosition()
    }

    fun getPathString(): String {
        return position.getPath()
    }

    private fun moveForward() {
        position.add()
    }

    companion object {
        private const val DEFAULT_POSITION_VALUE = 0
    }

}
