package racingcar.domain

class RacingCar(initPosition: Position = Position()) {

    var position: Position = initPosition
        private set

    fun move(movingDirection: MovingDirection) {
        this.position.plus(movingDirection.position)
    }
}
