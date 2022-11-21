package racingcar

class Car private constructor(private var moveCount: Int = 0) {
    constructor() : this(0)

    fun move(moveNumber: Int): Int {
        if (moveNumber >= MINIMUM_BOUND) {
            moveCount ++
        }
        return moveCount
    }

    companion object {
        private const val MINIMUM_BOUND = 4
    }
}
