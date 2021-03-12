package racing.ui

import racing.data.RacingGameResult
import racing.data.RacingHistory
import racing.data.RoundResult
import racing.data.Winners

object ResultView {

    private const val SYMBOL_ONE_STEP = "-"
    private const val NOTICE_RESULT_START = "실행결과"
    private const val NAME_DELIMETER_FOR_DISPLAY = ", "

    fun printRacingResult(racingGameResult: RacingGameResult) {
        printResultNotice()
        printRacingHistory(racingGameResult.racingHistory)
        printWinners(racingGameResult.winners)
    }

    private fun printResultNotice() {
        println(NOTICE_RESULT_START)
    }

    private fun printRacingHistory(racingHistory: RacingHistory) {
        val racingResults = racingHistory.roundResults
        racingResults.forEach { printRoundResult(it) }
    }

    private fun printRoundResult(roundResult: RoundResult) {
        val carStates = roundResult.carStates
        carStates.forEach {
            printCarStates(it.name.value, it.position.value)
        }
        println()
    }

    private fun printCarStates(name: String, position: Int) {
        println("$name : ${SYMBOL_ONE_STEP.repeat(position)}")
    }

    private fun printWinners(winners: Winners) {
        val winnerNames = winners.joinWinnerNamesToString(NAME_DELIMETER_FOR_DISPLAY)
        println("${winnerNames}가 최종 우승했습니다.")
    }
}
