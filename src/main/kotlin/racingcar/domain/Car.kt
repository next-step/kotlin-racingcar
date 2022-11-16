package racingcar.domain

class Car(var position: Position = Position()) {

    fun moveForward(moveStrategy: MoveStrategy) {
        this.position = position.moveForward(moveStrategy)
    }
}
