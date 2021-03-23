package car

import car.domain.CarNames
import car.domain.Cars
import car.domain.winner.Winners
import car.view.Input
import car.view.InputView
import car.view.ResultView

fun main() {
    val inputView = InputView()

    val names = inputView.inputNames()
    val tryCount = inputView.inputTryCount()
    val prettyString = inputView.inputPrettyString()

    val input = Input(names, tryCount, prettyString)

    val cars = Cars(CarNames(input.splitNameBySplitter()))
    cars.move(input.tryCount)

    val winners: Winners = Winners(cars)

    val resultView = ResultView()

    resultView.print(cars, input)
    resultView.printWinners(winners)
}
