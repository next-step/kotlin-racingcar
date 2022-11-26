package racingcar.domain

class Car(position: Position = Position()) {

    var position = position
        private set

    fun moveForward(moveStrategy: MoveStrategy) {
        this.position = position.moveForward(moveStrategy)
    }
}
