package carRace.view

import carRace.domain.Car
import carRace.domain.CarRaceResult

class ResultView {
    private fun printCars(cars: List<Car>) {
        cars.forEach { car ->
            car.print()
        }
        println()
    }

    private fun printWinners(winners: List<Car>) {
        print("${winners.joinToString(",") { it.driverName }}가 최종 우승했습니다.")
    }

    fun printResult(carRaceResult: CarRaceResult) {
        carRaceResult.history.forEach {
            if (it.lap == 1) {
                println("실행결과")
            }
            printCars(it.cars)
        }

        printWinners(carRaceResult.getWinners())
    }
    private fun Car.print() = println("$driverName: ${"-".repeat(traveled)}")
}
