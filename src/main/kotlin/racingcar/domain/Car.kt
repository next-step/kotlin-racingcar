package racingcar.domain

import racingcar.vo.Name
import racingcar.vo.Position

class Car(name: String, private var position: Position = Position()) {

    val name = Name(name)

    constructor(name: String, position: Int) : this(name, Position(position))

    fun moveForward(moveStrategy: MoveStrategy): Position = position.moveForward(moveStrategy).apply { this@Car.position = this }
}
