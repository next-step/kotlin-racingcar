package step3

import step3.ui.InputView
import step3.ui.ResultView

class GameManager(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val randomNumberGenerator: RandomNumberGenerator,
) {
    fun start() {
        val numberOfCar = inputView.getNumberOfCars()
        val attemptCount = inputView.getAttemptCount()
        val racingCars = (1..numberOfCar).map { id -> Car(id = id) }

        repeat(attemptCount) {
            playRound(racingCars)
            resultView.printRaceResults(racingCars)
        }
    }

    private fun playRound(racingCars: List<Car>) {
        racingCars.forEach {
            it.moveForward(randomNumberGenerator.generate())
        }
    }
}
