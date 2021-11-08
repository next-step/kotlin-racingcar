package racingcar.domain

class Car(val carName: CarName) {
    private var moveDistance = MoveDistance()

    fun moveCar(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            moveDistance.move()
        }
    }

    fun carPosition(): Int {
        return moveDistance.distance
    }
}
