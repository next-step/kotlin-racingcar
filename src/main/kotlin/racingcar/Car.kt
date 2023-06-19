package racingcar

import racingcar.strategy.MoveStrategy
import racingcar.strategy.RandomStrategy

class Car(position: Int = DEFAULT_POSITION, val moveStrategy: MoveStrategy = RandomStrategy()) {
    var position = position
        private set

    fun move(): Int {
        if (moveStrategy.canMove()) {
            position++
        }

        return position
    }

    companion object {
        const val DEFAULT_POSITION = 1
    }
}
