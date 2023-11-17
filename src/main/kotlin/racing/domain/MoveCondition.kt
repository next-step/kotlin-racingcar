package racing.domain

object MoveCondition {
    private val CAR_MOVE_CONDITION: () -> Boolean = { (0..9).random() >= 4 }

    fun movable(condition: () -> Boolean = CAR_MOVE_CONDITION): Boolean {
        return condition()
    }
}
