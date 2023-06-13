package racingcar.car

class Car(private val moveStrategy: MoveStrategy) {
    var position: Int = 0

    fun move() {
        if (moveStrategy.movable) {
            moveForward()
        }
    }

    private fun moveForward() {
        position += 1
    }
}