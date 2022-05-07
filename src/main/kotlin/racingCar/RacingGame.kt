package racingCar

import racingCar.controller.RacingController
import racingCar.view.InputView
import racingCar.view.ResultView

fun main() {
    val inputView = InputView()
    inputView.printHowManyCars()
    val countOfCar = inputView.getInput()
    inputView.printHowManyTimesRace()
    val countOfRace = inputView.getInput()

    val racingController = RacingController()
    racingController.startGame(countOfCar = countOfCar, countOfRace = countOfRace)

    val resultView = ResultView()
    resultView.printResult(racingController.raceResults)
}
