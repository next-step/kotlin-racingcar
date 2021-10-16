package racingcar.domain

class Position(
    var value: Int = 0,
) {
    fun change(): Position {
        return Position(value++)
    }
}
