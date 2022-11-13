package step3.domain.car

import step3.domain.car.action.MovingStrategy
import step3.domain.car.status.Position

data class Car(val position: Position = Position(0)) {
    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            position.move()
        }
    }
}
