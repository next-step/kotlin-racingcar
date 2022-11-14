package racingcar.domain.car

import racingcar.domain.car.action.MovingStrategy
import racingcar.domain.car.status.Position

data class Car(var position: Position = Position(0)) {
    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            position = Position(position.position + 1)
        }
    }
}
