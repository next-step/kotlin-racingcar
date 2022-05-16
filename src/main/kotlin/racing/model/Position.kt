package racing.model

data class Position(val position: Int = START_POSITION) {
    init {
        require(position >= MIN_POSITION) { INVALID_CAR_POSITION }
    }

    fun move(): Position = Position(position + 1)

    fun isMaxPosition(maxPosition: Int): Boolean {
        return position == maxPosition
    }

    companion object {
        private const val START_POSITION = 0
        private const val MIN_POSITION = 0
        const val INVALID_CAR_POSITION = "자동차의 초기 위치는 0이상 입니다."
    }
}
