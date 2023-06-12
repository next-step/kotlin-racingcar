package racing.view

import racing.car.Car
import racing.car.RacingCars

class ResultView {
    private val RACING_MARK = '-'
    fun showGameBoard(cars: RacingCars) {
        cars.racingCars.forEach {
            show(it)
        }
        println()
    }

    fun show(car: Car) {
        repeat(car.position) {
            print(RACING_MARK)
        }
        println()
    }
}
