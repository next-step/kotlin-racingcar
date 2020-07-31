package racingcar.racing.printer

import racingcar.racing.const.GAME_RESULT
import racingcar.racing.view.View
import racingcar.turn.Turn

class ResultPrinter(val printer: CarPrinter, val results: List<Turn>, val view: View) {
    fun print() {
        view.print(toPrintable())
    }

    fun toPrintable(): String {
        return results.joinToString(
            prefix = "\n$GAME_RESULT\n",
            separator = "\n"
        ) {
            it.cars.map { car ->
                printer.printString(car)
            }.joinToString(separator = "\n", postfix = "\n") {
                it
            }
        }
    }
}
