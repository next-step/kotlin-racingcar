package car.domain

data class Position(val value: Int = INIT_POSITION) {
    init {
        require(value >= 0) { "시작 위치는 $INIT_POSITION 보다 앞서 있어야 합니다." }
    }

    operator fun inc(): Position = Position(value + 1)

    companion object {
        const val INIT_POSITION = 0
    }
}
