package car.view

import car.domain.history.CarMoveHistories
import car.domain.Cars
import car.domain.winner.Winners
import car.view.print.CarMoveHistoryPrettyPrinter

class ResultView() {
    fun print(cars: Cars, input: Input) {
        val allMovedHistories: List<CarMoveHistories> = cars
            .map { it.histories }

        repeat(input.tryCount) { index ->
            printHistory(allMovedHistories, index, input.prettyPositionString)
            println()
        }
    }

    private fun printHistory(allMovedHistories: List<CarMoveHistories>, index: Int, prettyPrinter: String) {
        for (eachMoveHistories in allMovedHistories) {
            val printer = CarMoveHistoryPrettyPrinter(eachMoveHistories[index], prettyPrinter)
            println(printer)
        }
    }

    fun printWinners(winners: Winners) {
        print("$winners 가 최종 우승했습니다.")
    }
}
