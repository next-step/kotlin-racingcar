package racingcar.domain

import kotlin.math.max

@JvmInline
value class Position(val value: Int = 0) {
    init {
        require(value >= 0)
    }

    fun move(newPosition: Int): Position {
        return Position(value + newPosition)
    }

    fun getMaxPosition(comparePosition: Int): Int {
        return max(comparePosition, value)
    }

    fun isMaxPosition(maxPosition: Int): Boolean {
        return value == maxPosition
    }
}
