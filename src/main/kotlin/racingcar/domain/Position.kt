package racingcar.domain

class Position(val value: Int = 0) {
    fun move(newPos: Int): Position {
        return Position(value + newPos)
    }
}
