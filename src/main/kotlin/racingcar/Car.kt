package racingcar

import racingcar.data.MoveInfo

class Car(private var moveCount: Int = 0, private val name: String) {
    constructor(name: String) : this(0, name) {
        require(name.length <= 5) { "name length 5 limited" }
    }

    fun move(canMove: Boolean): MoveInfo = MoveInfo(name, if (canMove) ++ moveCount else moveCount)
}
