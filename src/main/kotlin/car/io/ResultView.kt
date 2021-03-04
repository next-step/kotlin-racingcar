package car.io

import car.business.CarMoveHistories
import car.business.Cars

class ResultView(private val cars: Cars) {
    fun print() {
        val allHistories = cars.allHistories
        for (carMoveHistory in allHistories) {
            printCarPositionHistory(carMoveHistory)
            println()
        }
        printFrontCars(allHistories.last())
    }

    private fun printCarPositionHistory(carMoveHistories: CarMoveHistories) {
        for (history in carMoveHistories) {
            println(history)
        }
    }

    private fun printFrontCars(carMoveHistories: CarMoveHistories) {
        val frontHistories = carMoveHistories.getFrontHistories()

        val winnerNames = frontHistories.joinToString { it.car.name }

        print("$winnerNames 가 최종 우승했습니다.")
    }
}
