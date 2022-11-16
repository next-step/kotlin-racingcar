package racingcar.domain.car

import racingcar.domain.car.action.MovingStrategy
import racingcar.domain.car.status.Name
import racingcar.domain.car.status.Position

data class Car(private val carName: String) {
    val name: Name = Name(carName)
    var position: Position = Position(0)
        private set 

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            position = Position(position.value + 1)
        }
    }
}
