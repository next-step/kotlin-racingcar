package racingcar.domain

class Position(
    private var position: Int = DEFAULT_POSITION,
) {
    fun forward() {
        position++
    }

    companion object {
        const val DEFAULT_POSITION = 0
    }

    fun getPosition(): Int {
        return position
    }

    fun equal(other: Position): Boolean {
        return position == other.getPosition()
    }
}
