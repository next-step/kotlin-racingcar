package racingcar.domain

import racingcar.strategy.MoveStrategy
import racingcar.strategy.RandomStrategy

class Car(val name: CarName, position: Position = Position(), val moveStrategy: MoveStrategy = RandomStrategy()) {
    var position = position
        private set

    fun move(): Position {
        if (moveStrategy.canMove()) {
            position = position.copy(value = position.value + 1)
        }

        return position
    }
}
