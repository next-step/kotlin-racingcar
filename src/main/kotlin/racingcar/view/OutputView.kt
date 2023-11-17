package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars

object OutputView {

    private const val WINNER_JOIN_SEPARATOR = ","
    private const val RACING_COURSE = "-"
    fun printRacing(racingCars: Cars) {
        val result = buildString {
            racingCars.cars.forEach {
                appendLine("${it.name} : ${RACING_COURSE.repeat(maxOf(0, it.position))}")
            }
            appendLine()
        }
        println(result)
    }

    fun printWinners(winnerCars: List<Car>): String = buildString {
        val winnersCarNames = winnerCars
            .joinToString(WINNER_JOIN_SEPARATOR) { it.name }

        println("${winnersCarNames}가 최종 우승했습니다.")
    }
}
