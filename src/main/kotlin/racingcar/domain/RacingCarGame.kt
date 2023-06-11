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
}
