package racingcar.domain.car

import racingcar.domain.car.action.MovingStrategy
import racingcar.domain.car.status.Position

data class Car(val position: Position = Position(0)) {
    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            position.move()
        }
    }
}
