package racing.ui

import racing.Cars

class ResultView {
    fun makeResultView(cars: Cars) {
        val carList = cars.carList
        for (car in carList) {
            println("-".repeat(car.position))
        }
        println()
    }
}
