package racingcar.view

import racingcar.PositionHistory
import racingcar.RacingGameResult

object ResultView {
    private const val POSITION_CHARACTER = "-"

    fun init() {
        println("실행 결과")
    }

    fun printResult(result: RacingGameResult) {
        result.positionHistories.forEach { printResult(it) }

        val winnerNames = result.getWinnerNames()
        println("${winnerNames.joinToString(", ")}가 최종 우승했습니다.")
    }

    private fun printResult(positionsHistory: PositionHistory) {
        positionsHistory.positions.forEach { println("${it.name}: ${POSITION_CHARACTER.repeat(it.position)}") }
        println()
    }
}
