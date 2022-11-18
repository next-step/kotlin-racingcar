package racingcar

private const val MINIMUM_BOUND = 4

class Car(moveCount: Int = 0) {
    var moveCount = moveCount
        private set

    fun move(moveNumber: Int) {
        if (moveNumber >= MINIMUM_BOUND) {
            moveCount ++
        }
    }
}
