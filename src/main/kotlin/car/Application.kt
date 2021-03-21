package car

import car.domain.CarNames
import car.domain.Cars
import car.domain.winner.Winners
import car.view.InputView
import car.view.ResultView

fun main() {
    val inputView = InputView()
    val input = inputView.input()

    val cars = Cars(CarNames(input.splitNameBySplitter()))

    cars.move(input.tryCount)
    val winners: Winners = Winners(cars)

    val resultView = ResultView(cars, winners, input)
    resultView.print()
}
