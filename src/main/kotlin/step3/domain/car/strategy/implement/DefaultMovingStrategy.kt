package step3.domain.car.strategy.implement

import step3.domain.car.Position
import step3.domain.car.strategy.MovingStrategy

class DefaultMovingStrategy : MovingStrategy {
    override fun move(position: Position) = position.forward()
}
