package racingame.controller

import racingame.domain.Car
import racingame.domain.Cars
import racingame.domain.RacingGame
import racingame.view.InputView
import racingame.view.OutputView

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
