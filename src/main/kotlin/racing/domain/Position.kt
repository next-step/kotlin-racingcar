package racing.domain

data class Position(val value: Int = MIN_POSITION_VALUE) : Comparable<Position> {

    init {
        require(value >= MIN_POSITION_VALUE)
    }

    fun move(): Position {
        return Position(value + DEFAULT_MOVE_VALUE)
    }

    override fun compareTo(other: Position): Int {
        return this.value - other.value
    }

    companion object {
        private const val MIN_POSITION_VALUE = 0
        private const val DEFAULT_MOVE_VALUE = 1
    }
}
