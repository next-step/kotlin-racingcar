package racingcar.domain

class Car(val name: String = "") {
    var position = 0
        private set

    fun move(movingConditionStrategy: MovingConditionStrategy) {
        if (movingConditionStrategy.move() >= MOVE_FORWARD) {
            markCarPosition(MOVE_VALUE)
        }
    }

    private fun markCarPosition(value: Int) {
        position += value
    }

    fun getCarName(): String {
        return this.name
    }

    fun getCarPosition(): Int {
        return this.position
    }

    companion object {
        const val MOVE_FORWARD = 4
        const val MOVE_VALUE = 1
    }
}
