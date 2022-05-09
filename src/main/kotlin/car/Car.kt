package car

class Car {
    var position: Int = 0
        private set

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            position += 1
        }
    }
}
