package racingcar

import racingcar.condition.MoveCondition
import racingcar.strategy.MoveStrategy

class Car(
    val name: String,
    private val moveStrategy: MoveStrategy,
    private val moveConditions: List<MoveCondition>,
    position: Int,
) {
    var position: Int = position
        private set

    fun move(): Int {
        if (isMovable()) {
            position = position.plus(SPEED)
        }
        return position
    }

    private fun isMovable(): Boolean {
        return moveStrategy.isMovable(moveConditions)
    }

    companion object {
        const val SPEED = 1
    }
}
