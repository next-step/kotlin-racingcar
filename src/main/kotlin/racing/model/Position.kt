package racing.model

data class Position(val position: Int = START_POSITION) : Comparable<Position> {
    init {
        require(position >= MIN_POSITION) { INVALID_CAR_POSITION }
    }

    fun move(): Position = Position(position + 1)

    fun isMaxPosition(maxPosition: Position): Boolean {
        return this == maxPosition
    }

    override fun compareTo(other: Position): Int {
        return position - other.position
    }

    companion object {
        private const val START_POSITION = 0
        private const val MIN_POSITION = 0
        const val INVALID_CAR_POSITION = "자동차의 초기 위치는 0이상 입니다."
    }
}
