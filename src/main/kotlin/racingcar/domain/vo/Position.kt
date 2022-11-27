package racingcar.domain.vo

import racingcar.domain.MoveStrategy

data class Position(val position: Int = 0) : Comparable<Position> {
    init {
        require(position >= MIN_THRESHOLD) { "The minimum value for position should be greater than $MIN_THRESHOLD" }
    }

    fun moveForward(moveStrategy: MoveStrategy): Position {
        return if (moveStrategy.canMove()) {
            Position(position + 1)
        } else {
            this
        }
    }

    companion object {
        private const val MIN_THRESHOLD = 0
    }

    override fun compareTo(other: Position): Int =
        when {
            this.position > other.position -> 1
            this.position < other.position -> -1
            else -> 0
        }
}
