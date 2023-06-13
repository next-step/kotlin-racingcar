package step3.controller

import step3.domain.Car
import step3.domain.RacingGame
import step3.view.InputView
import step3.view.OutputView

class GameController {

    fun start() {
        val nameOfCars = InputView.requestNameOfCars()
        val totalTrialCount: Int = InputView.requestCountOfTrial()
        val cars = nameOfCars.map { Car(it) }

        val racingGame = RacingGame(cars, totalTrialCount)
        racingGame.run()

        OutputView.printWinner(racingGame.getWinners())
    }
}
