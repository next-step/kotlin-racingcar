package racingcar.domain

@JvmInline
value class Position(val value: Int = 0) {
    init {
        verify(value)
    }

    private fun verify(value: Int) {
        require(value >= MIN_VALUE) { "위치는 1이하일 수 없습니다." }
    }

    fun move(): Position = Position(value + 1)

    companion object {
        private const val MIN_VALUE = 0
    }
}
