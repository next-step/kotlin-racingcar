package racingcar.strategy

import racingcar.condition.MoveCondition

class SatisfySingleConditionMoveStrategy : MoveStrategy {
    override fun isMovable(moveConditions: List<MoveCondition>): Boolean {
        return moveConditions.any { condition -> condition.isAvailable() }
    }
}
