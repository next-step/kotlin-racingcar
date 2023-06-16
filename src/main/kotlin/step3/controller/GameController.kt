package step3.controller

import step3.domain.Car
import step3.domain.Cars
import step3.domain.RacingGame
import step3.view.InputView
import step3.view.OutputView

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun start() {
        val nameOfCars = inputView.requestNameOfCars()
        val totalTrialCount: Int = inputView.requestCountOfTrial()
        val cars = Cars(nameOfCars.map { Car(it) })

        val racingGame = RacingGame(cars, totalTrialCount)
        outputView.printResult()
        val winner = racingGame.run()

        OutputView().printPositionOfCars(racingGame.positionHistories)
        outputView.printWinner(winner.winnerNames)
    }
}
