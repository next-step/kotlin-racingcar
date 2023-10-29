package racingcar.domain

class RacingCar(initPosition: Position = Position(0)) {

    var position: Position = initPosition
        private set

    fun move(movingDirection: MovingDirection) {
        this.position = this.position.plus(movingDirection.position)
    }

    fun isSamePosition(other: RacingCar): Boolean {
        return position == other.position
    }
}
