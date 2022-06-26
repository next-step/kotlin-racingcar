package racingcar.domain.car

import racingcar.domain.moving.MoveStrategy
import racingcar.domain.position.Position

class Car(
    private val moveStrategy: MoveStrategy
) {
    private var _position = Position(0)

    val position: Position
        get() = _position

    fun move() {
        if (moveStrategy.isMovable()) {
            _position = Position(
                _position.value + 1
            )
        }
    }
}
