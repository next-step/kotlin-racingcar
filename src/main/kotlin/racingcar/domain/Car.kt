package racingcar.domain

class Car(carName: CarName) {
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
