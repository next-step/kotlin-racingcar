package racingcar

import racingcar.strategy.MoveStrategy
import racingcar.util.Validator

class Car(
    val name: String,
    private val moveStrategy: MoveStrategy,
    position: Int,
) {
    var position: Int = position
        private set

    init {
        Validator.validateCarNameStr(name)
    }

    fun move(): Int {
        if (isMovable()) {
            position = position.plus(SPEED)
        }
        return position
    }

    private fun isMovable(): Boolean {
        return moveStrategy.isMovable()
    }

    companion object {
        const val SPEED = 1
    }
}
