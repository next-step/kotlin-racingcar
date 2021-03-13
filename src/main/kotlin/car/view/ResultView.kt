package car.view

import car.domain.CarMoveHistoryCollection
import car.domain.Cars
import car.domain.Winners

class ResultView(private val cars: Cars) {
    fun print() {
        val allHistories = cars.histories
        for (carMoveHistory in allHistories) {
            printCarPositionHistory(carMoveHistory)
            println()
        }
        printWinners(cars.winners)
    }

    private fun printCarPositionHistory(carMoveHistoryCollection: CarMoveHistoryCollection) {
        for (history in carMoveHistoryCollection.moveHistories) {
            println(history)
        }
    }

    private fun printWinners(winners: Winners) {
        print("$winners 가 최종 우승했습니다.")
    }
}
