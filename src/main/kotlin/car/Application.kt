package car

import car.domain.CarNames
import car.domain.Cars
import car.view.InputView
import car.view.ResultView

fun main() {
    val inputView = InputView()
    val input = inputView.input()

    val cars = Cars(CarNames(input.splitNameBySplitter()))
    val resultView = ResultView(cars, input)

    cars.move(input.tryCount)
    resultView.print()
}
