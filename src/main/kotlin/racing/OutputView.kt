package racing

import racing.result.GameResult
import racing.result.RoundResult

object OutputView {
    private const val POSITION_MARK = "-"

    fun printResult(result: GameResult) {
        println("실행 결과")
        result.roundResults.forEach { printRoundResult(it) }
    }

    private fun printRoundResult(roundResult: RoundResult) {
        roundResult.racingHistories.forEach { racingHistory -> printPosition(racingHistory.position) }
        println()
    }

    private fun printPosition(currentPosition: Int) = with(StringBuilder()) {
        (1..currentPosition).forEach { _ -> append(POSITION_MARK) }
        println(toString())
    }
}