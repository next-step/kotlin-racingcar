package racing.model

import racing.exception.PositionException

data class Position(val value: Int = START_POSITION) : Comparable<Position> {
    init {
        if (value < MIN_POSITION) throw PositionException(INVALID_CAR_POSITION)
    }

    fun move(): Position = Position(value + 1)

    fun isMaxPosition(maxPosition: Position): Boolean {
        return this == maxPosition
    }

    override fun compareTo(other: Position): Int {
        return value.compareTo(other.value)
    }

    companion object {
        private const val START_POSITION = 0
        private const val MIN_POSITION = 0
        private const val INVALID_CAR_POSITION = "자동차의 초기 위치는 0이상 입니다."
    }
}
