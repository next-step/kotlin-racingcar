package racingcar.strategy

import racingcar.condition.MoveCondition

interface MoveStrategy {
    fun isMovable(moveConditions: List<MoveCondition>): Boolean
}
