package racingcar.view.printer

import racingcar.model.Car

private const val NAME_COLUMN_SEPARATOR = " : "
private const val TRACE_SYMBOL = "-"

class CarPrinter(car: Car) : Car by car {
    fun printTraceInfo() {
        print(name.value + NAME_COLUMN_SEPARATOR)
        repeat(position.value) {
            print(TRACE_SYMBOL)
        }
        println()
    }
}
