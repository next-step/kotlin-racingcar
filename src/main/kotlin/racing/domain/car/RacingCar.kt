package racing.domain.car

import racing.domain.movement.MoveStrategy

private const val MOVE_CONDITION = 4

class RacingCar(
    private val racingCarName: RacingCarName,
    private var position: Int = 0
) {
    fun move(moveStrategy: MoveStrategy): Int {
        if (canMove(moveStrategy.decisionNumber)) {
            position++
        }
        return position
    }

    private fun canMove(decisionNumber: Int) = decisionNumber >= MOVE_CONDITION
}
