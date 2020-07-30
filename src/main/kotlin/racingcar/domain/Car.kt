package racingcar.domain

import racingcar.strategy.Strategy

class Car(
    private val name: String,
    private val strategy: Strategy
) {
    var currentPosition = 0
        private set

    internal fun getName() = name

    internal fun isWinner(max: Int) = currentPosition == max

    override fun toString() = "$name : ${PRINT_CHARACTER.repeat(currentPosition)}\n"

    internal fun moveForward(): Int {
        if (strategy.canMove) currentPosition++
        return currentPosition
    }

    companion object {
        const val PRINT_CHARACTER = "-"
    }
}
