package racing

import racing.result.GameResult
import racing.result.RacingHistory
import racing.result.RoundResult
import racing.result.Winner

object OutputView {
    private const val POSITION_MARK = "-"

    fun printResult(result: GameResult) {
        println("실행 결과")
        result.roundResults.forEach { printRoundResult(it) }
        printWinner(result.getWinners())
    }

    private fun printRoundResult(roundResult: RoundResult) {
        roundResult.racingHistories.forEach { racingHistory -> printPosition(racingHistory) }
        println()
    }

    private fun printPosition(racingHistory: RacingHistory) =
        println("${racingHistory.name} : ${POSITION_MARK.repeat(racingHistory.position)}")

    private fun printWinner(winners: List<Winner>) =
        print("${winners.joinToString { it.name }}가 최종 우승했습니다")
}