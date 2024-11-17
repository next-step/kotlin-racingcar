package racingcar

class Car(
    moveCount: Int = 0,
    moveCountStr: String = "",
) {
    var moveCount: Int = moveCount
        private set
    var moveCountStr: String = moveCountStr
        private set

    fun move(number: Int) {
        if (number >= MOVE_MIN_CONDITION) {
            this.moveCount += MOVE_DISTANCE
            this.moveCountStr = MOVE_SYMBOL.repeat(this.moveCount)
        }
    }

    companion object {
        private const val MOVE_MIN_CONDITION = 4
        private const val MOVE_SYMBOL = "-"
        private const val MOVE_DISTANCE = 1
    }
}
