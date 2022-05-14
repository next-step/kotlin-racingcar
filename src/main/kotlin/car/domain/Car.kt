package car.domain

class Car(
    position: Position
) {
    var position: Position = position
        private set

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            position = position.increase()
        }
    }
}
