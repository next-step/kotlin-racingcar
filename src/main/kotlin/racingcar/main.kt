package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView
    val resultView = ResultView

    val nameOfCars = inputView.getNameOfCars()
    val tryCount = inputView.getTryCount()

    resultView.printResultTitle()
    val cars = Cars(nameOfCars.map { Car(name = it) })
    cars.game(tryCount)
    resultView.printWinners(cars.getWinners())
}
