package racingcar.domain

@JvmInline
value class Position private constructor(val value: Int = MIN_VALUE) {
    init {
        verify(value)
    }

    private fun verify(value: Int) {
        require(value >= MIN_VALUE) { "위치는 ${MIN_VALUE}미만일 수 없습니다." }
    }

    fun move(): Position = Position(value + 1)

    companion object {
        private val ZERO = Position(0)
        private const val MIN_VALUE = 0

        fun of(value: Int = MIN_VALUE): Position {
            if (value == MIN_VALUE) return ZERO
            return Position(value)
        }
    }
}
