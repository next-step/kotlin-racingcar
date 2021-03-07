package racingcar

import racingcar.ui.ResultView

class Game(val cars: Cars, private val numberOfAttempts: Int) {
    fun start() {
        val resultView = ResultView()
        repeat(numberOfAttempts) {
            proceedOneTurn()
            resultView.printCurrent(
                cars
            )
        }
        resultView.printWinner(cars.winner())
    }

    private fun proceedOneTurn() {
        cars.cars.forEach { car ->
            car.attemptsMoveForward()
        }
    }
}
