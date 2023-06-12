package racing.view

import racing.car.Car
import racing.car.RacingCars

class ResultView {
    private val RACING_MARK = "-"
    fun showGameBoard(cars: RacingCars) {
        cars.racingCars.forEach {
            show(it)
        }
        println()
    }

    fun show(car: Car) {
        val distance = RACING_MARK.repeat(car.getPosition())
        val carName = car.getName()
        print("$carName : $distance")
        println()
    }
}
