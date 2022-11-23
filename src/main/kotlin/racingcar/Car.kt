package racingcar

class Car private constructor(private var moveCount: Int = 0, val name: String) {
    constructor(name: String) : this(0, name)

    fun move(moveNumber: Int): Int {
        if (moveNumber >= MINIMUM_BOUND) {
            moveCount ++
        }
        return moveCount
    }
}
