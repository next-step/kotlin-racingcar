package racingcar.strategy

import racingcar.condition.MoveCondition

class SatisfyAllConditionStrategy : MoveStrategy {
    override fun isMovable(moveConditions: List<MoveCondition>): Boolean {
        return moveConditions.all { condition -> condition.isAvailable() }
    }
}
