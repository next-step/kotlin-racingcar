package racingcar.view

import racingcar.domain.Car
import racingcar.domain.RacingGame

private const val RESULT_START_STRING = "\n실행 결과"
private const val MOVE_STRING = "-"
private const val WINNER_STRING = "가 최종 우승했습니다."

object ResultView {

    fun startPrintGame() = println(RESULT_START_STRING)

    fun printGameResult(gameResult: RacingGame) {
        gameResult.cars
            .forEach { println("${it.name} : ${MOVE_STRING.repeat(it.score)}") }
        println()
    }

    fun printGameWinner(winners: List<Car>) {
        println("${winners.joinToString(", ") { it.name }}$WINNER_STRING")
    }
}
