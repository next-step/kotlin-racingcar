package car.domain

class Car(
    _position: Position
) {
    var position: Position = _position
        private set

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            position = position.increase()
        }
    }
}
