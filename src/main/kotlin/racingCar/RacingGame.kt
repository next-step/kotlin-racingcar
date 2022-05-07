package racingCar

import racingCar.controller.RacingController
import racingCar.view.InputView
import racingCar.view.ResultView

fun main() {
    val inputView = InputView()
    inputView.printHowManyCars()
    val countOfCar = inputView.getNumber()
    inputView.printHowManyTimesRace()
    val countOfRace = inputView.getNumber()

    val racingController = RacingController()
    racingController.startGame(countOfCar = countOfCar, countOfRace = countOfRace)

    val resultView = ResultView()
    resultView.printResult(racingController.getResult())
}