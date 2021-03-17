package car.view

import car.domain.history.CarMoveHistoryCollection
import car.domain.CarCollection
import car.domain.winner.WinnerCollection

class ResultView(
    private val carCollection: CarCollection,
    private val input: Input
) {
    fun print() {
        var allCars = carCollection.cars

        val list: List<CarMoveHistoryCollection> = allCars
            .map { it.historyCollection }

        repeat(input.tryCount) { index ->
            printCarPositionHistory(list, index)
            println()
        }

        printWinners(WinnerCollection(carCollection))
    }

    private fun printCarPositionHistory(carMoveHistoryCollectionList: List<CarMoveHistoryCollection>, index: Int) {
        for (carMoveHistoryCollection in carMoveHistoryCollectionList) {
            val pretty =
                CarMoveHistoryPrettyPrinter(carMoveHistoryCollection.moveHistories[index], input.prettyPositionString)
            print(pretty)
            println()
        }
    }

    private fun printWinners(winnerCollection: WinnerCollection) {
        print("$winnerCollection 가 최종 우승했습니다.")
    }
}
