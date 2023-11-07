package racingcar

import racingcar.controller.RacingCarController
import racingcar.domain.RacingGame
import racingcar.domain.Car
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val countOfCars = InputView.inputCountOfCars()
    val countOfTry = InputView.inputCountOfTry()

    val cars = List(countOfCars) {
        Car()
    }

    ResultView.printInit()
    ResultView.printResult(RacingCarController(countOfTry, RacingGame(cars)).start())
}
