package racingcar.domain.car

import racingcar.domain.car.action.MovingStrategy
import racingcar.domain.car.status.Name
import racingcar.domain.car.status.Position

data class Car(val name: Name) {
    var position: Position = Position(0)
        private set

    constructor(name: String) : this(Name(name))

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            position = Position(position.value + 1)
        }
    }
}
