package racingcar.domain

@JvmInline
value class Position(val value: Int) {

    init {
        require(value in MIN_POSITION..MAX_POSITION) {
            "$MIN_POSITION ~ $MAX_POSITION 사이의 포지션만 입력할 수 있습니다."
        }
    }

    fun plus(other: Position): Position = Position(this.value + other.value)

    companion object {
        private const val MIN_POSITION = 0
        private const val MAX_POSITION = Int.MAX_VALUE
    }
}
