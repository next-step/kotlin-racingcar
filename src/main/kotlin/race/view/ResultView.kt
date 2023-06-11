package race.view

import race.Car

class ResultView {
    fun showAllPosition(cars: List<Car>) {
        for (car in cars) {
            show(car)
        }
        println()
    }

    private fun show(car: Car) {
        repeat(car.position) {
            print('-')
        }
        println()
    }
}
