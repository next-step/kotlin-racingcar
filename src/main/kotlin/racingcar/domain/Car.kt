package racingcar.domain

class Car(private var moveCount: Int = 0, val name: String) {
    constructor(name: String) : this(0, name) {
        require(name.length <= 5) { "name length 5 limited" }
    }

    fun move(canMove: Boolean): Int = if (canMove) ++ moveCount else moveCount
}
