package racingcar.domain.car

@JvmInline
value class Position(val value: Int = 0) {
    init {
        require(value >= 0) { "위치는 0 이상만 가능합니다." }
    }

    val next: Position
        get() = Position(value + 1)
}
