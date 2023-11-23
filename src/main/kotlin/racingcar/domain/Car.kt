package racingcar.domain

import racingcar.strategy.MoveStrategy

data class Car(
    val name: String,
    val moveStrategy: MoveStrategy
) {

    var position: Int = 0
        private set

    constructor(name: String, moveStrategy: MoveStrategy, position: Int) : this(name, moveStrategy) {
        this.position = position
    }

    fun move() {
        if (moveStrategy.getMoveCount() >= FORWARD_CONDITION) {
            this.position++
        }
    }

    companion object {
        private const val FORWARD_CONDITION = 4
    }
}
