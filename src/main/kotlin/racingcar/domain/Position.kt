package racingcar.domain

class Position(val value: Int = 0) {
    init {
        require(value >= 0)
    }

    fun move(newPosition: Int): Position {
        return Position(value + newPosition)
    }
}
