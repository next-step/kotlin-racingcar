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

    fun isWinner(max: Int) = currentPosition == max

    fun getDistance() = PRINT_CHARACTER.repeat(currentPosition)

    fun moveForward(): Int {
        if (strategy.canMove) currentPosition++
        return currentPosition
    }
}
