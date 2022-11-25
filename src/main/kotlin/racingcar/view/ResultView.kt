package racingcar.view

import racingcar.service.RacingGame
import racingcar.view.printer.CarsPrinter

object ResultView {
    fun printHeader() {
        println("\n실행결과")
    }

    fun printDashboard(racingGame: RacingGame) {
        val printer = CarsPrinter(racingGame.cars)
        printer.printDashboard()
    }

    fun printWinners(racingGame: RacingGame) {
        val printer = CarsPrinter(racingGame.winners())
        printer.printWinners()
    }
}
