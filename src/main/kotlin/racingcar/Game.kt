package racingcar

import racingcar.ui.ResultView

class Game(val cars: Cars, private val numberOfAttempts: Int) {
    fun start() {
        repeat(numberOfAttempts) {
            proceedOneTurn()
            ResultView().printCurrent(
                cars
            )
        }
        // ResultView().printWinner(cars.winner())
    }

    private fun proceedOneTurn() {
        cars.cars.forEach { car ->
            car.attemptsMoveForward()
        }
    }
}
