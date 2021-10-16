package racingcar.domain.vo

@JvmInline
value class Position(val value: Int = 1) {
    init {
        require(value >= 1) { "위치는 1보다 작을 수 없습니다." }
    }

    fun moved(): Position = Position(value + 1)
}
