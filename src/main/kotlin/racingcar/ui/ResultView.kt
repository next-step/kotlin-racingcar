package racingcar.ui

import racingcar.Car

internal class ResultView {
    init {
        println("실행 결과")
    }

    fun printCarMove(car: Car, tryCount: Int) {
        println(getMoveString(car.moveHistory[tryCount]))
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
