package ui

import Car

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
