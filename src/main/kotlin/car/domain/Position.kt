package car.domain

private const val MIN_POSITION = 0

@JvmInline
value class Position(
    val value: Int
) {
    init {
        require(value >= MIN_POSITION) { "위치 객체는 음수가 될수 없습니다." }
    }

    fun increase(): Position = Position(value.inc())
}
