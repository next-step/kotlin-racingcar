package racingcars.ui

import racingcars.Car

class ResultView {
    fun printRaceResults(racingCars: List<Car>) = printCurrentPosition(racingCars)

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
