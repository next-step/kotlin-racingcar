package racingcar.domain

data class Position(private val position: Int = 0) {
    init {
        if (position < MIN_THRESHOLD) throw IllegalArgumentException("The minimum value for position should be greater than $MIN_THRESHOLD")
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
}
