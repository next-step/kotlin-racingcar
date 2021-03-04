package racing.domain.car

import racing.domain.movement.MoveStrategy

class RacingCar(
    val racingCarName: RacingCarName,
    var position: Int = 0
) {
    fun move(moveStrategy: MoveStrategy): RacingCar {
        if (canMove(moveStrategy)) {
            position++
        }
        return this
    }

    private fun canMove(moveStrategy: MoveStrategy) = moveStrategy.decisionNumber >= MOVE_CONDITION

    companion object {
        private const val MOVE_CONDITION = 4
    }
}
