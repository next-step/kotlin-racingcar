package car.view

import car.domain.history.CarMoveHistories
import car.domain.Cars
import car.domain.winner.Winners
import car.view.print.CarMoveHistoryPrettyPrinter

class ResultView(
    private val cars: Cars,
    private val winners: Winners,
    private val input: Input
) {
    fun print() {
        val allMovedHistories: List<CarMoveHistories> = cars
            .map { it.histories }

        repeat(input.tryCount) { index ->
            printHistory(allMovedHistories, index)
            println()
        }

        printWinners(winners)
    }

    private fun printHistory(allMovedHistories: List<CarMoveHistories>, index: Int) {
        for (eachMoveHistories in allMovedHistories) {
            val printer = CarMoveHistoryPrettyPrinter(eachMoveHistories[index], input.prettyPositionString)
            println(printer)
        }
    }

    private fun printWinners(winners: Winners) {
        print("$winners 가 최종 우승했습니다.")
    }
}
