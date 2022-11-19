package racingcar.view

import racingcar.domain.Car
import racingcar.utils.joinToStringByComma

object OutputView {
    private const val MOVE = "-"

    fun showMovingCarResult(cars: List<Car>) {
        cars.forEach { println("${it.name} : ${MOVE.repeat(it.currentPosition)}") }
        println()
    }

    fun showWinners(winners: List<String>) {
        println("${winners.joinToStringByComma()}가 최종 우승 했습니다.")
    }
}
