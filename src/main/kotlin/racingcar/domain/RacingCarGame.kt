package racingcar.domain

import racingcar.util.randomNumber

class RacingCarGame(
    val racingCars: List<RacingCar>,
    private val numberOfAttempts: Int,
    private var currentNumber: Int = 0
) {

    fun racing() {
        racingCars.forEach {
            it.move(randomNumber())
        }
    }

    fun racingAttemptsCheck(): Boolean {
        if (currentNumber >= numberOfAttempts) {
            return false
        }

        currentNumber++
        return true
    }

    fun winners(): String {
        val maxPosition = maxPosition()
        return createWinners(maxPosition)
    }

    private fun maxPosition(): Int {
        var maxPosition = 0;
        racingCars
            .asSequence()
            .filter { it.position() > maxPosition }
            .forEach { maxPosition = it.position() }

        return maxPosition;
    }

    private fun createWinners(maxPosition: Int): String {
        val winners = mutableListOf<String>()
        racingCars
            .asSequence()
            .filter { it.position() == maxPosition }
            .forEach { winners.add(it.name()) }

        return winners.joinToString { it }
    }
}
