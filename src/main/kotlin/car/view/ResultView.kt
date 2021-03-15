package car.view

import car.domain.CarMoveHistoryCollection
import car.domain.CarCollection
import car.domain.Winners

class ResultView(private val carCollection: CarCollection, private val times: Int) {
    fun print() {
        var allCars = carCollection.cars

        val list: List<CarMoveHistoryCollection> = allCars
            .map { it.historyCollection }

        repeat(times) { index ->
            printCarPositionHistory(list, index)
            println()
        }
        printWinners(Winners(carCollection))
    }

    private fun printCarPositionHistory(carMoveHistoryCollectionList: List<CarMoveHistoryCollection>, index: Int) {
        for (carMoveHistoryCollection in carMoveHistoryCollectionList) {
            print(carMoveHistoryCollection.moveHistories[index])
            println()
        }
    }

    private fun printWinners(winners: Winners) {
        print("$winners 가 최종 우승했습니다.")
    }
}
