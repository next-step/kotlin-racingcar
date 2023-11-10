package racing.domain

object CarRacingConditionImpl : CarRacingCondition {
    private const val START_RANGE = 0
    private const val END_RANGE = 9
    private const val MOVABLE_MINIMUM = 4

    override fun getNumber(): Int = (START_RANGE..END_RANGE).random()

    override fun canMove(): Boolean = getNumber() >= MOVABLE_MINIMUM
}
