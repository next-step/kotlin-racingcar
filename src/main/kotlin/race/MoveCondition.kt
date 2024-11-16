package race

class MoveCondition(private val value: PositiveNumber) {
    fun shouldMove(): Boolean {
        return value.isGreaterThanOrEqual(MOVE_CONDITION)
    }

    companion object {
        private val MOVE_CONDITION = PositiveNumber(4)
    }
}
