package racing.domain

object MoveCondition {
    fun movable(): Boolean {
        return (0..9).random() >= 4
    }
}
