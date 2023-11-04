package racingcar.view

import racingcar.domain.Cars

class ResultView {

    companion object {
        private const val POSITION_SYMBOL = "-"

        fun printResultStart() {
            println("\n실행 결과")
        }

        fun printResult(cars: Cars) {
            for (car in cars.getCars()) {
                println(POSITION_SYMBOL.repeat(car.getPosition()))
            }
            println()
        }
    }
}
