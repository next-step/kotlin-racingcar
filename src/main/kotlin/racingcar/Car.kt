package racingcar

class Car(
    moveCount: Int = 0,
) {
    var moveCount: Int = moveCount
        private set

    fun move(number: Int) {
        if (number >= MOVE_MIN_CONDITION) {
            this.moveCount += MOVE_DISTANCE
        }
    }

    companion object {
        private const val MOVE_MIN_CONDITION = 4
        private const val MOVE_DISTANCE = 1
    }
}
