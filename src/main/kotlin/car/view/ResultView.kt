package car.view

import car.domain.history.CarMoveHistories
import car.domain.winner.Winners
import car.view.input.PrettyPrinterInput
import car.view.print.CarMoveHistoryPrettyPrinter

class ResultView {
    fun print(allMovedHistories: List<CarMoveHistories>, expression: String) {
        repeat(allMovedHistories.size) { index ->
            printHistory(allMovedHistories[index], expression)
            println()
        }
    }

    fun printWinners(winners: Winners) {
        print("$winners 가 최종 우승했습니다.")
    }

    private fun printHistory(careMoveHistories: CarMoveHistories, expression: String) {
        for (eachMoveHistories in careMoveHistories) {
            val printer = CarMoveHistoryPrettyPrinter(eachMoveHistories, expression)
            println(printer)
        }
    }
}
