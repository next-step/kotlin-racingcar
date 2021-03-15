package car.view

import car.domain.CarMoveHistoryCollection
import car.domain.CarCollection
import car.domain.CarMoveHistoryPrettyPrinter
import car.domain.WinnerCollection

class ResultView(
    private val carCollection: CarCollection,
    private val times: Int,
    private val prettyPositionString: String
) {
    fun print() {
        var allCars = carCollection.cars

        val list: List<CarMoveHistoryCollection> = allCars
            .map { it.historyCollection }

        repeat(times) { index ->
            printCarPositionHistory(list, index)
            println()
        }

        printWinners(WinnerCollection(carCollection))
    }

    private fun printCarPositionHistory(carMoveHistoryCollectionList: List<CarMoveHistoryCollection>, index: Int) {
        for (carMoveHistoryCollection in carMoveHistoryCollectionList) {
            val pretty =
                CarMoveHistoryPrettyPrinter(carMoveHistoryCollection.moveHistories[index], prettyPositionString)
            print(pretty)
            println()
        }
    }

    private fun printWinners(winnerCollection: WinnerCollection) {
        print("$winnerCollection 가 최종 우승했습니다.")
    }
}
