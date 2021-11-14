package racingcar.domain

class Car(val carName: CarName, private val moveDistance: MoveDistance = MoveDistance()) {

    fun moveCar(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            moveDistance.move()
        }
    }

    fun carPosition(): Int {
        return moveDistance.distance
    }

    fun isSameCarMaxPositionMessage(maxPosition: Int): Boolean {
        return moveDistance.isSameCarPosition(maxPosition)
    }
}
