package racingcar.domain

import racingcar.vo.Position

class Car(position: Position = Position()) {
    var position: Position = position
        private set

    fun move(canMove: () -> Boolean) {
        position = if (canMove.invoke()) position.move() else position
    }
}
