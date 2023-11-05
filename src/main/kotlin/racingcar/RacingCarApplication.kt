package racingcar

import racingcar.controller.CarController
import racingcar.domain.Car
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val countOfCars = InputView.inputCountOfCars()
    val countOfTry = InputView.inputCountOfTry()

    val cars = mutableListOf<Car>()

    for (i in 0 until countOfCars step 1) {
        cars.add(Car())
    }

    ResultView.printResultInit()
    for (i in 0 until countOfTry step 1) {
        CarController(cars).race()
        ResultView.printResult(cars)
    }
}
