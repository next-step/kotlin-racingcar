package car.domain

private const val DEFAULT_POSITION = 0
private const val MIN_POSITION = 0
data class Position(
    val value: Int = DEFAULT_POSITION
) {
    init {
        require(value >= MIN_POSITION) { "자동차 위치는 음수가 될수 없습니다." }
    }

    fun increase(): Position = Position(value.inc())
}
