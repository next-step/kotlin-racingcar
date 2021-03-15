package car

import car.domain.CarNameCollection
import car.domain.CarCollection
import car.view.InputView
import car.view.ResultView

fun main() {
    val inputView = InputView()
    val input = inputView.input()

    val cars = CarCollection(CarNameCollection(input.splitNameBySplitter()))
    val resultView = ResultView(cars, input.tryCount, input.prettyPositionString)

    cars.move(input.tryCount)
    resultView.print()
}
