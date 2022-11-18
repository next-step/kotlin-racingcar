package racingcar.domain.strategy

import racingcar.domain.condition.MoveCondition

class SatisfyAllConditionStrategy(
    private val moveConditions: List<MoveCondition>
) : MoveStrategy {
    override fun isMovable(): Boolean {
        return moveConditions.all { condition -> condition.isAvailable() }
    }
}
