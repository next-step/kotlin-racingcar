package racingcar.ui

import racingcar.history.RacingActionHistory
import racingcar.history.RacingRoundHistory

object OutputView {
    private const val DASH_LINE = "-"

    fun printOutputLetter() = println("실행 결과")

    fun printRacingGame(racingRoundHistories: List<RacingRoundHistory>) =
        racingRoundHistories.forEach {
            printCarCollection(it.racingActionHistories)
            println()
        }

    private fun printCarCollection(positions: List<RacingActionHistory>) = positions.forEach { printCarLine(it) }

    private fun printCarLine(actionHistory: RacingActionHistory) = println(DASH_LINE.repeat(actionHistory.position))
}
