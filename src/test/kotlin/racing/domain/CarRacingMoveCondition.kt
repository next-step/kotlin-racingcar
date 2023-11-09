package racing.domain

object CarRacingMoveCondition : CarRacingCondition {
    override fun getNumber(): Int = 9

    override fun canMove(): Boolean = true
}
