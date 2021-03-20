package car.view

import car.domain.history.CarMoveHistoryCollection
import car.domain.CarCollection
import car.domain.winner.WinnerCollection
import car.view.printer.CarMoveHistoryPrettyPrinter

class ResultView(
    private val carCollection: CarCollection,
    private val input: Input
) {
    fun print() {
        val carHistoryCollections: List<CarMoveHistoryCollection> = carCollection
            .map { it.historyCollection }

        repeat(input.tryCount) { index ->
            printCarPositionHistory(carHistoryCollections, index)
            println()
        }

        printWinners(WinnerCollection(carCollection))
    }

    private fun printCarPositionHistory(allHistories: List<CarMoveHistoryCollection>, index: Int) {
        for (carMoveHistoryCollection in allHistories) {
            val pretty = CarMoveHistoryPrettyPrinter(carMoveHistoryCollection[index], input.prettyPositionString)
            println(pretty)
        }
    }

    private fun printWinners(winnerCollection: WinnerCollection) {
        print("$winnerCollection 가 최종 우승했습니다.")
    }
}
