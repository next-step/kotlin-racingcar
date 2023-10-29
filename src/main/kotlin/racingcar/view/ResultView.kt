package racingcar.view

import racingcar.domain.Car

object ResultView {
    fun printResultText() {
        ConsolePrinter.printMsg("\n실행 결과")
    }

    fun printResultState(cars: List<Car>) {
        cars.forEach {
            ConsolePrinter.printMsg(it.state)
        }
        ConsolePrinter.printMsg("")
    }
}