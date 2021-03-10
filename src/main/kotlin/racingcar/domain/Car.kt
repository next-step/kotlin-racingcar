package racingcar.domain

class Car(val name: CarName, private val moveStrategy: MoveStrategy, private val moveDepth: Int = 1) {

    var distance: Int = 0
        private set

    fun moveIfMoveable() {
        if (moveStrategy.isMoveable()) {
            move()
        }
    }

    private fun move() {
        distance += moveDepth
    }
}
