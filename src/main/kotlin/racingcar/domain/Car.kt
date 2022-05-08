package racingcar.domain

import racingcar.domain.MovementCommand.FORWARD

class Car {
    var position: Int = 0
        private set

    fun move(movementCommand: MovementCommand) {
        if (movementCommand == FORWARD) position++
    }
}
