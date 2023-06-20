package racingcar.car

class Car(val carName: CarName, private val moveStrategy: MoveStrategy) {

    private var position: Position = Position()

    fun move() {
        if (moveStrategy.movable()) {
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
}
