package racingcar.view

import racingcar.model.Car
import racingcar.service.RacingGame

private const val NAME_COLUMN_SEPARATOR = " : "
private const val TRACE_SYMBOL = "-"

object ResultView {
    fun printHeader() {
        println("\n실행결과")
    }

    fun printDashboard(racingGame: RacingGame) {
        racingGame.cars.forEach { printTraceInfo(it) }
        println()
    }

    private fun printTraceInfo(car: Car) {
        print(car.name.value + NAME_COLUMN_SEPARATOR)
        repeat(car.position.value) {
            print(TRACE_SYMBOL)
        }
        println()
    }

    fun printWinners(racingGame: RacingGame) {
        val winnerNames = racingGame.winners()
            .map { it.name.value }
            .reduce { s1, s2 -> "$s1, $s2" }
        println(winnerNames + "가 최종 우승했습니다.")
    }
}
