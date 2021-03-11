package car.io

import car.business.CarMoveHistoryCollection
import car.business.Cars

class ResultView(private val cars: Cars) {
    fun print() {
        val allHistories = cars.histories
        for (carMoveHistory in allHistories) {
            printCarPositionHistory(carMoveHistory)
            println()
        }
        printWinners(allHistories.last())
    }

    private fun printCarPositionHistory(carMoveHistoryCollection: CarMoveHistoryCollection) {
        for (history in carMoveHistoryCollection.moveHistories) {
            println(history)
        }
    }

    private fun printWinners(carMoveHistoryCollection: CarMoveHistoryCollection) {
        val frontHistories = carMoveHistoryCollection.getWinners()

        val winnerNames = frontHistories.joinToString { it.carName }

        print("$winnerNames 가 최종 우승했습니다.")
    }
}
