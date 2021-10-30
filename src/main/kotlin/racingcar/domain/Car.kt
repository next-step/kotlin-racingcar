package racingcar.domain

class Car {
    private var moveDistance: MoveDistance = MoveDistance()

    fun moveCar(movingStrategy: MovingStrategy) {
        if(movingStrategy.movable()) {
            moveDistance.move()
        }
    }

    fun carPosition(): Int {
        return moveDistance.distance
    }
}
