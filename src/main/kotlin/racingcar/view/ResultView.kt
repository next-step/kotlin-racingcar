package racingcar.view

import racingcar.model.Car
import racingcar.service.RacingGame

private const val NAME_COLUMN_SEPARATOR = " : "
private const val TRACE_SYMBOL = "-"

object ResultView {
    fun printHeader() {
        println("\n실행결과")
    }

    fun printDashBoard(racingGame: RacingGame) {
        val cars = racingGame.cars
        cars.forEach { printCarTrace(it) }
        println()
    }

    private fun printCarTrace(car: Car) {
        print(car.name.value + NAME_COLUMN_SEPARATOR)
        repeat(car.position.value) {
            print(TRACE_SYMBOL)
        }
        println()
    }

    fun printWinner(racingGame: RacingGame) {
        val winnerNames = racingGame.winners()
            .map { it.name.value }
            .reduce { s1, s2 -> "$s1, $s2" }
        println(winnerNames + "가 최종 우승했습니다.")
    }
}
