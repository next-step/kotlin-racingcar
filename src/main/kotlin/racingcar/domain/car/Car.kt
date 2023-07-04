package racingcar.domain.car

import racingcar.domain.movingstrategy.MovingStrategy

class Car(
    private val movingStrategy: MovingStrategy,
    private val name: CarName,
) {
    var position: Position = Position()
        private set

    val currentInfo: CarInfo
        get() = CarInfo(name.value, position.value)

    constructor(movingStrategy: MovingStrategy, name: String) : this(movingStrategy, CarName(name))

    fun move() {
        if (movingStrategy.isMovable()) {
            this.position = position.next
        }
    }
}
