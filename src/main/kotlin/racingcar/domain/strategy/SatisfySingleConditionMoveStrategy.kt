package racingcar.domain.strategy

import racingcar.domain.condition.MoveCondition

class SatisfySingleConditionMoveStrategy(
    private val moveConditions: List<MoveCondition>
) : MoveStrategy {
    override fun isMovable(): Boolean {
        return moveConditions.any { condition -> condition.isAvailable() }
    }
}
