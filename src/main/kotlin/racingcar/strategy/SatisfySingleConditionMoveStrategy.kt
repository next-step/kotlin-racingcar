package racingcar.strategy

import racingcar.condition.MoveCondition

class SatisfySingleConditionMoveStrategy(
    private val moveConditions: List<MoveCondition>
) : MoveStrategy {
    override fun isMovable(): Boolean {
        return moveConditions.any { condition -> condition.isAvailable() }
    }
}
