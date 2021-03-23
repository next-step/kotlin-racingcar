package car

import car.domain.CarNames
import car.domain.Cars
import car.domain.winner.Winners
import car.view.InputView
import car.view.ResultView

fun main() {
    val inputView = InputView()

    val names = inputView.inputNames()
    val tryCount = inputView.inputTryCount()
    val prettyString = inputView.inputPrettyString()

    val cars = Cars(CarNames(names.splitNameBySplitter()))
    cars.move(tryCount.count)

    val winners: Winners = Winners(cars)

    val resultView = ResultView()

    resultView.print(cars, tryCount, prettyString)
    resultView.printWinners(winners)
}
