package step3.ui

import step3.Car

class ResultView {
    fun printCurrentPosition(racingCars: List<Car>) {
        racingCars.forEach { car ->
            println(positionToString(car.position))
        }
        println()
    }

    fun positionToString(position: Int): String {
        return "-".repeat(position)
    }
}
