package racingcar.domain.car.strategy.implement

import racingcar.domain.car.Position
import racingcar.domain.car.strategy.MovingStrategy

class DefaultMovingStrategy : MovingStrategy {
    override fun move(position: Position) = position.forward()
}
