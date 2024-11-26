package racingcar.domain

import kotlin.math.max

private const val DEFAULT_NUMBER = 0
private const val MOVE_START_NUMBER = 0
private const val MOVE_END_NUMBER = 9
private const val MOVE_POSITION_CONDITION = 4

private const val POSITION_VIEW = "-"

@JvmInline
value class Position(val position: Int) {
    fun move(number: Int): Position {
        if (number < MOVE_START_NUMBER || number > MOVE_END_NUMBER) {
            throw IllegalArgumentException("Only numbers between 0 and 9 can be entered. input number:$number")
        }

        if (number >= MOVE_POSITION_CONDITION) {
            return Position(position + 1)
        }

        return this
    }

    fun viewPosition(): String {
        return POSITION_VIEW.repeat(max(DEFAULT_NUMBER, position))
    }

    companion object {
        fun init(): Position {
            return Position(DEFAULT_NUMBER)
        }
    }
}
