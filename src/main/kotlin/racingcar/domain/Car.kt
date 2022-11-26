package racingcar.domain

class Car(private var position: Position = Position()) {

    fun moveForward(moveStrategy: MoveStrategy): Position {
        this.position = position.moveForward(moveStrategy)
        return this.position
    }
}
