package car

import car.business.Cars
import car.io.InputView
import car.io.ResultView

fun main() {
    val inputView = InputView()
    val input = inputView.input()

    val cars = Cars(input.amount)
    val resultView = ResultView(cars)

    for(i in 0 until input.tryCount) {
        cars.move()
        resultView.print()
    }

}