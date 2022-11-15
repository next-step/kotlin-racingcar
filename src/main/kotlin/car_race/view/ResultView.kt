package car_race.view

import car_race.logic.car.CarPosition
import car_race.logic.car.Cars

object ResultView {

    fun printEachRound(cars: Cars) {
        cars.getPositions().forEach { carPosition ->
            printPosition(carPosition)
        }
        println()
    }

    private fun printPosition(carPosition: CarPosition) {
        println("-".repeat(carPosition.getValue() + 1))
    }
}
