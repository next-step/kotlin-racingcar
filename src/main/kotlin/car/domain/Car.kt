package car.domain

import car.domain.move.MovableStrategy

class Car(
    val carName: CarName,
    position: Position = Position(),
    private val movableStrategy: MovableStrategy
) {
    var position: Position = position
        private set

    constructor(
        carName: String,
        position: Int = Position.INIT_POSITION,
        movableStrategy: MovableStrategy
    ) : this(CarName(carName), Position(position), movableStrategy)

    fun move() {
        if (movableStrategy.movable) {
            position++
        }
    }
}
