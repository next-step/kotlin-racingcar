package racingcar.io

import racingcar.CarRecord
import racingcar.GameResult
import racingcar.Record

object ResultView {
    private const val TRACE = "-"
    private const val EXPLAIN_WINNER_MESSAGE = "가 최종 우승했습니다."
    private const val SEPARATOR = ","

    fun print(gameResult: GameResult) {
        gameResult.forEach { record ->
            printOneRound(record)
        }
        printWinner(gameResult)
    }

    private fun printWinner(gameResult: GameResult) {
        val frontRunners = gameResult
            .getLastRoundRecord()
            .findFrontRunner()
        val winnerNames = extractWinnerNames(frontRunners)
        println("$winnerNames$EXPLAIN_WINNER_MESSAGE")
    }

    private fun printOneRound(record: Record) {
        record.forEach { (name, position) ->
            println("$name : ${TRACE.repeat(position + 1)}")
        }
        println()
    }

    private fun extractWinnerNames(frontRunners: List<CarRecord>): String {
        return frontRunners.joinToString(SEPARATOR) { it.name }
    }
}
