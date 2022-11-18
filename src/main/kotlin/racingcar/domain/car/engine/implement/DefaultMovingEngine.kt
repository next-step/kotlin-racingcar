package racingcar.domain.car.engine.implement

import racingcar.domain.car.Position
import racingcar.domain.car.engine.MovingEngine

class DefaultMovingEngine : MovingEngine {
    override fun move(position: Position) = position.forward()
}
