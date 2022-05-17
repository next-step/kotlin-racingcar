package car.domain.vo

private const val MIN_POSITION = 0

@JvmInline
value class Position(
    val value: Int
) : Comparable<Position> {
    init {
        require(value >= MIN_POSITION) { "위치값은 음수가 될수 없습니다." }
    }

    fun increase(): Position = Position(value.inc())

    override fun compareTo(other: Position): Int = value - other.value
}
