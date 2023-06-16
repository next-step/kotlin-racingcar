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
    }

    private fun printResult(positionsHistory: PositionHistory) {
        positionsHistory.positions.forEach { println(POSITION_CHARACTER.repeat(it)) }
        println()
    }
}
