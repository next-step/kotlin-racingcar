package racingcar

class Car(
    var moveCount: Int = 0,
    var moveCountStr: String = "",
) {
    companion object {
        private const val MOVE_MIN_CONDITION = 4
        private const val MOVE_SYMBOL = "-"
        private const val MOVE_DISTANCE = 1
    }

    fun move(number: Int) {
        if (number >= MOVE_MIN_CONDITION) {
            this.moveCount += MOVE_DISTANCE
            this.moveCountStr = MOVE_SYMBOL.repeat(this.moveCount)
        }
    }
}
