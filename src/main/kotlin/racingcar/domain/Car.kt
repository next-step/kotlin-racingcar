package racingcar.domain

class Car(val carName: CarName, private val moveDistance: MoveDistance) {

    constructor(carName: CarName) : this(carName, MoveDistance())

    fun moveCar(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            moveDistance.move()
        }
    }

    fun carPosition(): Int {
        return moveDistance.distance
    }
}
