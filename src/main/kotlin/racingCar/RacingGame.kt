package racingCar

import racingCar.controller.RacingController
import racingCar.view.InputView
import racingCar.view.ResultView

fun main() {
    val carNames = InputView.getCarNames()
    val numberOfRaces = InputView.getNumberOfRaces()

    val racingController = RacingController()
    racingController.startGame(carNames = carNames, numberOfRaces = numberOfRaces)

    ResultView.printResult(racingController.raceResults)
}
