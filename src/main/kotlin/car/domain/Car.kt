package car.domain

import car.domain.history.CarMoveHistory
import car.domain.history.CarMoveHistories
import car.domain.move.MovableStrategy

class Car(
    val carName: CarName,
    position: Position = Position(),
    private val movableStrategy: MovableStrategy
) {
    var histories: CarMoveHistories = CarMoveHistories()
        private set

    private var _position: Position = position
    val position: Int
        get() = _position.value

    constructor(
        carName: String,
        position: Int = Position.INIT_POSITION,
        movableStrategy: MovableStrategy
    ) : this(CarName(carName), Position(position), movableStrategy)

    fun move() {
        if (movableStrategy.movable) {
            _position++
        }

        histories = histories.add(CarMoveHistory(carName, _position))
    }

    fun isPositionMoreThan(position: Int) = this.position >= position
}
