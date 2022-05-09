package car

import car.domain.CarRacing
import car.ui.InputView

fun main() {
    val (numberOfCar, tryCount) = InputView.input()

    val race = CarRacing().race(numberOfCar, tryCount)
    println()
}
