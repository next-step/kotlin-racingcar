package racing.domain

object CarRacingStopCondition : CarRacingCondition {
    override fun getNumber(): Int = 0

    override fun canMove(): Boolean = false
}
