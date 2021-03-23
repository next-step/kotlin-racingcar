package car.view

import car.domain.history.CarMoveHistories
import car.domain.Cars
import car.domain.winner.Winners
import car.view.input.PrettyPrinterInput
import car.view.input.TryCountInput
import car.view.print.CarMoveHistoryPrettyPrinter

class ResultView {
    fun print(cars: Cars, tryCount: TryCountInput, prettyPrinter: PrettyPrinterInput) {
        val allMovedHistories: List<CarMoveHistories> = cars
            .map { it.histories }

        repeat(tryCount.count) { index ->
            printHistory(allMovedHistories, index, prettyPrinter)
            println()
        }
    }

    fun printWinners(winners: Winners) {
        print("$winners 가 최종 우승했습니다.")
    }

    private fun printHistory(allMovedHistories: List<CarMoveHistories>, index: Int, prettyPrinter: PrettyPrinterInput) {
        for (eachMoveHistories in allMovedHistories) {
            val printer = CarMoveHistoryPrettyPrinter(eachMoveHistories[index], prettyPrinter)
            println(printer)
        }
    }
}
