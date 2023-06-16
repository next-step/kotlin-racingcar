package study.racinggame.domain

@JvmInline
value class Position(val value: Int = 1) : Comparable<Position> {
    init {
        if (value < 1) {
            throw CanNotNegativePositionException(value)
        }
    }

    fun next(): Position {
        return Position(this.value + 1)
    }

    override fun compareTo(other: Position): Int {
        return value - other.value
    }
}

class CanNotNegativePositionException(value: Int) : RuntimeException("위치값은 0보다 작을 수 없습니다. (value = $value)")
