package racingcar.domain

class Car(private val name: String, private val moveStrategy: MoveStrategy, private val moveDepth: Int = 1) {

    private var distance: Int = 0

    fun moveIfMoveable() {
        if (moveStrategy.isMoveable()) {
            move()
        }
    }

    private fun move() {
        distance += moveDepth
    }

    fun currentDistance(): Int {
        return distance
    }

    fun displayName(): String {
        return name
    }
}
