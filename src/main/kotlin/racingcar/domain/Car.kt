package racingcar.domain

class Car {
    private var moveDistance: MoveDistance = MoveDistance()

    fun moveCar(movingStrategy: Boolean) {
        if (movingStrategy) {
            moveDistance.move()
        }
    }

    fun carPosition(): Int {
        return moveDistance.distance
    }
}
