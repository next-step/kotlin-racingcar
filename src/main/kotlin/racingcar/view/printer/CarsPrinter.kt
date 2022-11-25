package racingcar.view.printer

import racingcar.model.Car
import racingcar.model.Cars

class CarsPrinter(cars: Cars) : Cars by cars {
    fun printDashboard() {
        value.forEach { printCarTrace(it) }
        println()
    }

    private fun printCarTrace(car: Car) {
        val printer = CarPrinter(car)
        printer.printTraceInfo()
    }

    fun printWinners() {
        val winnerNames = value.map { it.name.value }
            .reduce { s1, s2 -> "$s1, $s2" }
        println(winnerNames + "가 최종 우승했습니다.")
    }
}
