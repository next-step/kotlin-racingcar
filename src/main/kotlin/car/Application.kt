package car

import car.business.CarNameCollection
import car.business.Cars
import car.io.InputView
import car.io.ResultView

fun main() {
    val inputView = InputView()
    val input = inputView.input()

    val cars = Cars(CarNameCollection(input.splitNameBySplitter()))
    val resultView = ResultView(cars)

    cars.move(input.tryCount)
    resultView.print()
}
