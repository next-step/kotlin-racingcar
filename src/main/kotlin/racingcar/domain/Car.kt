package racingcar.domain

import racingcar.strategy.Strategy

class Car(
    private val name: String = "car",
    private val strategy: Strategy
) {
    companion object {
        const val PRINT_CHARACTER = "-"
    }

    var currentPosition = 0
        private set

    internal fun getName() = name

    internal fun isWinner(max: Int) = currentPosition == max

    internal fun getDistance() = PRINT_CHARACTER.repeat(currentPosition)

    internal fun moveForward(): Int {
        if (strategy.canMove) currentPosition++
        return currentPosition
    }
}
