package racingcar

import racingcar.strategy.ForwardStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView
    val resultView = ResultView

    val nameOfCars = inputView.getNameOfCars()
    val tryCount = inputView.getTryCount()

    resultView.printResultTitle()
    val strategy = ForwardStrategy()
    val cars = Cars(nameOfCars.map { Car(name = it, strategy = strategy) })
    cars.game(tryCount)
    resultView.printWinners(cars.getWinners())
}
