package racingcar.ui

import racingcar.Car
import racingcar.RacingCarUtil

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

    private fun getMoveString(moveCount: Int): String = RacingCarUtil.createMoveString(moveCount)
}
