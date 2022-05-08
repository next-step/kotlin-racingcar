package racingCar

import racingCar.controller.RacingController
import racingCar.view.InputView
import racingCar.view.ResultView

fun main() {
    val inputView = InputView()
    val numberOfCars = inputView.getNumberOfCars()
    val numberOfRaces = inputView.getNumberOfRaces()

    val racingController = RacingController()
    racingController.startGame(numberOfCars = numberOfCars, numberOfRaces = numberOfRaces)

    val resultView = ResultView()
    resultView.printResult(racingController.raceResults)
}
