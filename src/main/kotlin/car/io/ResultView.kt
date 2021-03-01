package car.io

import car.business.CarMoveHistories
import car.business.Cars

class ResultView(val cars: Cars) {
    fun print() {
        val allHistories = cars.allHistories
        for (carMoveHistory in allHistories) {
            printCarPositionHistory(carMoveHistory)
            println()
        }
    }

    private fun printCarPositionHistory(carMoveHistories: CarMoveHistories) {
        for (history in carMoveHistories) {
            println("-".repeat(history.position))
        }
    }
}
