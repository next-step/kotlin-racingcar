package racingcar.domain.strategy

import racingcar.domain.condition.MoveCondition
import racingcar.domain.condition.RandomMoveCondition

class SatisfyRandomMoveStrategy(
    private val moveCondition: MoveCondition = RandomMoveCondition()
) : MoveStrategy {
    override fun isMovable(): Boolean {
        return moveCondition.isAvailable()
    }
}
