package car

import car.domain.CarNameCollection
import car.domain.Cars
import car.view.InputView
import car.view.ResultView

fun main() {
    val inputView = InputView()
    val input = inputView.input()

    val cars = Cars(CarNameCollection(input.splitNameBySplitter()))
    val resultView = ResultView(cars)

    cars.move(input.tryCount)
    resultView.print()
}
