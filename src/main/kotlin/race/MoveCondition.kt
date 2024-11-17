package race

object MoveCondition {
    private val MOVE_CONDITION = PositiveNumber(4)

    fun shouldMove(condition: PositiveNumber): Boolean {
        return condition.isGreaterThanOrEqual(MOVE_CONDITION)
    }
}
