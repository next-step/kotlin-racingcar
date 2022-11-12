package racingcar.io

import racingcar.GameResult
import racingcar.Record

object ResultView {
    private const val TRACE = "-"

    fun print(gameResult: GameResult) {
        gameResult.forEach { record ->
            printOneRound(record)
        }
    }

    private fun printOneRound(record: Record) {
        record.forEach { (name, position) ->
            println("$name : ${TRACE.repeat(position + 1)}")
        }
        println()
    }
}
