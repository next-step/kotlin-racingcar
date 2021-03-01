package car

import car.business.Cars
import car.io.InputView
import car.io.ResultView

fun main() {
    val inputView = InputView()
    val input = inputView.input()

    val cars = Cars(input.amount)
    val resultView = ResultView(cars)

    repeat(input.tryCount) {
        cars.move()
        resultView.print()
    }
}
