package racingcar.io

import racingcar.GameResult

object ResultView {
    private const val TRACE = "-"

    fun print(gameResult: GameResult) {
        gameResult.forEach { record ->
            record.forEach { position ->
                println(TRACE.repeat(position + 1))
            }
            println()
        }
    }
}
