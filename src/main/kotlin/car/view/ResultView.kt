package car.view

import car.domain.history.CarMoveHistories
import car.domain.winner.Winners
import car.view.input.PrettyPrinterInput
import car.view.input.TryCountInput
import car.view.print.CarMoveHistoryPrettyPrinter

class ResultView {
    fun print(allMovedHistories: List<CarMoveHistories>, tryCount: TryCountInput, prettyPrinter: PrettyPrinterInput) {
        repeat(tryCount.count) { index ->
            printHistory(allMovedHistories[index], prettyPrinter)
            println()
        }
    }

    fun printWinners(winners: Winners) {
        print("$winners 가 최종 우승했습니다.")
    }

    private fun printHistory(careMoveHistories: CarMoveHistories, prettyPrinter: PrettyPrinterInput) {
        for (eachMoveHistories in careMoveHistories) {
            val printer = CarMoveHistoryPrettyPrinter(eachMoveHistories, prettyPrinter)
            println(printer)
        }
    }
}
