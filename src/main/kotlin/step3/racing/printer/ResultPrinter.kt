package step3.racing.printer

import step3.racing.const.GAME_RESULT
import step3.racing.view.View
import step3.turn.Turn

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
