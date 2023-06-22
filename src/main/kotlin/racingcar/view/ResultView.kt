package racingcar.view

import racingcar.RoundHistory
import racingcar.RacingGameResult

object ResultView {
    private const val POSITION_CHARACTER = "-"

    fun init() {
        println("실행 결과")
    }

    fun printResult(result: RacingGameResult) {
        result.roundHistories.map { printResult(it) }

        val winnerNames = result.getWinnerNames()
        println("${winnerNames.joinToString(", ")}가 최종 우승했습니다.")
    }

    private fun printResult(positionsHistory: RoundHistory) {
        positionsHistory.positionHistories.forEach { println("${it.name}: ${POSITION_CHARACTER.repeat(it.position)}") }
        println()
    }
}
