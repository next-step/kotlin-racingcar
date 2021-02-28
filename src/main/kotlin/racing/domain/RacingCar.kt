package racing.domain

private const val MOVE_CONDITION = 4

class RacingCar(private var position: Int = 0) {
    fun move(moveStrategy: MoveStrategy): Int {
        if (canMove(moveStrategy.decisionNumber)) {
            position++
        }
        return position
    }

    private fun canMove(decisionNumber: Int) = decisionNumber >= MOVE_CONDITION
}
