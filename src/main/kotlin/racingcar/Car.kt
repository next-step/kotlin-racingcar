package racingcar

import racingcar.condition.MoveCondition
import racingcar.strategy.MoveStrategy
import racingcar.util.Validator

class Car(
    val name: String,
    private val moveStrategy: MoveStrategy,
    position: Int,
) {
    var position: Int = position
        private set

    init {
        Validator.validateCarNameStr(name)
    }

    fun move(moveConditions: List<MoveCondition>): Int {
        if (isMovable(moveConditions)) {
            position = position.plus(SPEED)
        }
        return position
    }

    private fun isMovable(moveConditions: List<MoveCondition>): Boolean {
        return moveStrategy.isMovable(moveConditions)
    }

    companion object {
        const val SPEED = 1
    }
}
