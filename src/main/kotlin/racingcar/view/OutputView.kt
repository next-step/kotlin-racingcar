package racingcar.view

import racingcar.dto.CarDto
import racingcar.dto.CarsDto

object OutputView {

    private const val WINNER_JOIN_SEPARATOR = ","
    fun printRacing(snapShots: List<CarsDto>) {
        val result = buildString {
            snapShots.forEach {
                appendLine(it.racingTrace())
            }
        }
        println(result)
    }

    fun printWinners(winnerCars: List<CarDto>): String = buildString {
        val winnersCarNames = winnerCars
            .joinToString(WINNER_JOIN_SEPARATOR) { it.name }

        println("${winnersCarNames}가 최종 우승했습니다.")
    }
}
