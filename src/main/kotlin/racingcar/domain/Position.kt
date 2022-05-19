package racingcar.domain

private const val INITIAL_POSITION = 0

@JvmInline
value class Position(
    val value: Int = INITIAL_POSITION,
) : Comparable<Position> {
    init {
        check(value >= INITIAL_POSITION) { "자동차의 처음 position은 0이상의 숫자만 가능합니다. position = $value" }
    }

    fun next(): Position = this + ONE

    operator fun plus(other: Position): Position = Position(this.value + other.value)

    companion object {
        private val ONE = Position(1)
        val ZERO = Position(INITIAL_POSITION)
    }

    override fun compareTo(other: Position): Int {
        return this.value.compareTo(other.value)
    }
}
