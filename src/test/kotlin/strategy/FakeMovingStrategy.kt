package strategy

import racingcar.strategy.MovingStrategy

class FakeMovingStrategy(private val canMove: Boolean): MovingStrategy {
    override fun canMove(): Boolean = canMove
}
