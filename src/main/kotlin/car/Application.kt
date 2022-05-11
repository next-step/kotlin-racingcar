package car

import car.domain.CarRacing
import car.domain.Cars
import car.ui.InputView
import car.ui.OutputView

fun main() {
    val (numberOfCar, tryCount) = InputView.input()

    val cars = Cars(numberOfCar)

    OutputView.result()

    repeat(tryCount.value) {
        CarRacing.race(cars).run { OutputView.output(this) }
    }
}
