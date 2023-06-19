package racingcar

class Car {
    var position: Int = DEFAULT_POSITION
        private set

    fun move(condition: Int) {
        if (condition >= MOVE_CONDITION) {
            position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION: Int = 0
        private const val MOVE_CONDITION: Int = 4
    }
}
