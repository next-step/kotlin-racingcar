package racingcar.strategy

import racingcar.condition.MoveCondition

class SatisfyAllConditionStrategy(
    private val moveConditions: List<MoveCondition>
) : MoveStrategy {
    override fun isMovable(): Boolean {
        return moveConditions.all { condition -> condition.isAvailable() }
    }
}
