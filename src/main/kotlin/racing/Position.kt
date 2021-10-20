package racing

private const val INITIAL_POSITION_VALUE = 0
private const val STEP = 1

val INITIAL_POSITION = Position(INITIAL_POSITION_VALUE)

@JvmInline
value class Position(val value: Int) : Comparable<Position> {

    init {
        require(value >= INITIAL_POSITION_VALUE) { "Position은 ${INITIAL_POSITION_VALUE}보다 크거나 같아야합니다." }
    }

    fun forward() = Position(value + STEP)

    override fun compareTo(other: Position): Int {
        return compareValues(value, other.value)
    }
}
