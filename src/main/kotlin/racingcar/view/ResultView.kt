package racingcar.view

import racingcar.domain.PositionHistory
import racingcar.domain.RacingGameResult
import racingcar.domain.RoundHistory

object ResultView {
    private const val POSITION_CHARACTER = "-"

    fun init() {
        println("실행 결과")
    }

    fun printResult(result: RacingGameResult) {
        result.roundHistories.map { printRoundHistory(it) }

        val winnerNames = result.getWinnerNames()
        println("${winnerNames.value.joinToString(", ") { it.value }}가 최종 우승했습니다.")
    }

    private fun printRoundHistory(roundHistory: RoundHistory) {
        roundHistory.positionHistories.forEach { printPositionHistory(it) }
        println()
    }

    private fun printPositionHistory(positionsHistory: PositionHistory) {
        println("${positionsHistory.name.value}: ${POSITION_CHARACTER.repeat(positionsHistory.position.value)}")
    }
}
