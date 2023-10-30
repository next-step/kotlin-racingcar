package racingcar.view

import racingcar.domain.Car

object ResultView {
    const val STATE_UNIT = "-"

    fun printResultText() {
        ConsolePrinter.printMsg("\n실행 결과")
    }

    fun printResultState(cars: List<Car>) {
        cars.forEach {
            ConsolePrinter.printMsg(STATE_UNIT.repeat(it.location))
        }
        ConsolePrinter.printMsg("")
    }
}