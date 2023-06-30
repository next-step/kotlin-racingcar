package racingcar.domain

class Car(val carName: CarName, private val moveStrategy: MoveStrategy) {

    private var position: Position = Position()

    fun move() {
        if (moveStrategy.movable()) {
            moveForward()
        }
    }

    fun getPosition(): Int
    {
        return position.getPosition()
    }

    private fun moveForward() {
        position.add()
    }
}
