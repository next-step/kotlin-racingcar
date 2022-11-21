package racingcar

class Car(private var moveCount: Int = 0) {
    val moveHistory = ArrayList<Int>()

    fun move(moveNumber: Int): Int {
        if (moveNumber >= MINIMUM_BOUND) {
            moveCount ++
        }

        moveHistory.add(moveCount)
        return moveCount
    }

    companion object {
        private const val MINIMUM_BOUND = 4
    }
}
