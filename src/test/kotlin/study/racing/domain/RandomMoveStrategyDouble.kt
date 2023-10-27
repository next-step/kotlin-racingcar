package study.racing.domain

import study.racing.strategy.MoveStrategy

class RandomMoveStrategyDouble(
    private val isMoving: Boolean
) : MoveStrategy {
    override fun isMoving(): Boolean {
        return isMoving
    }
}
