package car_racing

import car_racing.car.Car
import car_racing.ui.InputView
import car_racing.ui.ResultView

class CarRacing {
    fun start(tryNumber: Int, cars: List<Car>) {
        repeat(tryNumber) {
            cars.forEach {
                it.move()
            }
        }
    }
}

fun main() {
    val (carNumber, tryNumber) = InputView.readlines()
    val cars = MutableList(carNumber) { Car(tryNumber) }
    CarRacing().start(tryNumber, cars)
    ResultView(tryNumber, cars).draw()
}
