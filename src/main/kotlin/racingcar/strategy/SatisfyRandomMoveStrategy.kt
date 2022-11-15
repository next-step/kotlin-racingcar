package racingcar.strategy

import racingcar.condition.MoveCondition
import racingcar.condition.RandomMoveCondition

class SatisfyRandomMoveStrategy(
    private val moveCondition: MoveCondition = RandomMoveCondition()
) : MoveStrategy {
    override fun isMovable(): Boolean {
        return moveCondition.isAvailable()
    }
}
