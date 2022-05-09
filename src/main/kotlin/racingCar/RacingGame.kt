package racingCar

import racingCar.controller.RacingController
import racingCar.view.InputView
import racingCar.view.ResultView

fun main() {
    val numberOfCars = InputView.getNumberOfCars()
    val numberOfRaces = InputView.getNumberOfRaces()

    val racingController = RacingController()
    racingController.startGame(numberOfCars = numberOfCars, numberOfRaces = numberOfRaces)

    ResultView.printResult(racingController.raceResults)
}
