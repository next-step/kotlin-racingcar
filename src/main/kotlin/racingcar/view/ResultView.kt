package racingcar.view

import racingcar.domain.Cars

class ResultView {

    companion object {
        private const val POSITION_SYMBOL = "-"

        fun moveAndPrintResult(cars: Cars, tryCount: Int = 1) {
            println("\n실행 결과")
            for (i in 1..tryCount) {
                cars.move()
                printResult(cars)
            }
        }

        fun printResult(cars: Cars) {
            for (car in cars.getCars()) {
                println(POSITION_SYMBOL.repeat(car.getPosition()))
            }
            println()
        }
    }
}
