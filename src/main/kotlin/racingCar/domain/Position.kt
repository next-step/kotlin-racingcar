package racingCar.domain

@JvmInline
value class Position(val position: Int = 1) {
    init {
        require(position > 0) { "위치값은 0보다 작을수 없습니다." }
    }

    fun increase(): Position = Position(position + 1)

}
