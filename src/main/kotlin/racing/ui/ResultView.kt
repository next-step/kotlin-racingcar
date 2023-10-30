package racing.ui

import racing.Cars

class ResultView {
    fun makeResultView(cars: Cars) {
        val carList = cars.carList
        for (car in carList) {
            println("-".repeat(car.currentPosition))
        }
        println()
    }

    fun makeResultViewWithName(cars: Cars) {
        val carList = cars.carList
        carList.forEach { car ->
            val positionGraph = "-".repeat(car.currentPosition)
            println("$car.name : $positionGraph")
        }
    }
}
