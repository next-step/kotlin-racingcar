package racingcar.strategy

import racingcar.condition.MoveCondition
import racingcar.const.MoveConditionType

class SatisfyRandomMoveStrategy : MoveStrategy {
    private val availableCondition = listOf(MoveConditionType.RANDOM)
    override fun isMovable(moveConditions: List<MoveCondition>): Boolean {
        return moveConditions.filter { condition ->
            condition.conditionType in availableCondition
        }.all { it.isAvailable() }
    }
}
