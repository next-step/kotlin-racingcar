package racing.domain

interface CarRacingCondition {
    fun getNumber(): Int
    fun canMove(): Boolean
}
