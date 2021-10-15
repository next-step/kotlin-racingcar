package racingcar.domain

class Position(
    val value: Int = 0,
) {
    companion object {
        private const val INCREASE = 1
    }

    fun change(): Position {
        return Position(value.plus(INCREASE))
    }
}
