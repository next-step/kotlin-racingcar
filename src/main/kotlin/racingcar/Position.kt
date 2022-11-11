package racingcar

@JvmInline
value class Position(val value: Int) {
    init {
        require(value >= 0) { "위치는 0이상 이어야 합니다." }
    }

    operator fun inc(): Position = Position(value + 1)

    companion object {
        val ZERO = Position(0)
    }
}
