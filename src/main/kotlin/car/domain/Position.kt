package car.domain

data class Position(
    val value: Int = 0
) {
    init {
        require(value >= 0) { "자동차 위치는 음수가 될수 없습니다." }
    }

    fun increase(): Position = Position(value + 1)
}
