package racingcar.domain

import racingcar.domain.vo.Name
import racingcar.domain.vo.Position

class Car(name: String, position: Position = Position()) {
    val name: Name = Name(name)
    var position: Position = position
        private set

    constructor(name: String, position: Int) : this(name, Position(position))

    fun moveForward(moveStrategy: MoveStrategy): Position {
        this.position = position.moveForward(moveStrategy)

        return position
    }
}
