package racingcar.view

import racingcar.domain.GameResults
import racingcar.domain.Position

object ResultView {

    fun printGameResults(gameResults: GameResults) {
        printPositionsHeader()
        for (position in gameResults.positions) {
            printPositions(position.values)
        }
        printWinners(gameResults.winners)
    }

    private fun printPositionsHeader() {
        println("실행 결과")
    }

    private fun printPositions(positions: List<Position>) {
        val progressBar = positions.joinToString(separator = "\n", postfix = "\n") { "${it.name} : " + "-".repeat(it.position) }
        println(progressBar)
    }

    private fun printWinners(winners: List<String>) {
        val winnerNames = winners.joinToString(separator = ", ")
        println("${winnerNames}가 최종 우승했습니다.")
    }
}
