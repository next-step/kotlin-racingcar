package racingcar.ui

import racingcar.Car

internal class ResultView {
    init {
        println("실행 결과")
    }

    fun printCarState(car: Car) {
        println(getMoveString(car.moveCount))
    }

    fun printLineSpacing() {
        println()
    }

    fun getMoveString(moveCount: Int): String =
        StringBuilder().apply {
            for (i in 0 until moveCount) {
                append("-")
            }
        }.toString()
}
