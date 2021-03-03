package racing.ui

import racing.data.RacingHistory
import racing.data.RoundResult

/**
 * @author tae-heon.song<taeheon.song@linecorp.com>
 * @since 2021. 02. 28.
 */
object ResultView {

    private const val SYMBOL_ONE_STEP = "-"
    private const val NOTICE_RESULT_START = "실행결과"
    private const val NAME_DELIMETER_FOR_DISPLAY = ", "
    private const val EXCEPTION_MESSAGE_EMPTY_LIST = "리스트의 값이 존재하지 않습니다."

    fun printResultNotice() {
        println(NOTICE_RESULT_START)
    }

    fun printRacingHistory(racingHistory: RacingHistory) {
        val racingResults = racingHistory.roundResults
        racingResults.forEach { printRoundResult(it) }
    }

    private fun printRoundResult(roundResult: RoundResult) {
        val carStates = roundResult.carStates
        carStates.forEach { (carName, carPosition) ->
            printCarStates(carName.name, carPosition.position)
        }
        println()
    }

    private fun printCarStates(name: String, position: Int) {
        print("$name : ")
        repeat(position) {
            print(SYMBOL_ONE_STEP)
        }
        println()
    }

    fun printWinners(names: List<String>) {
        val winnerNames = names.joinToString(NAME_DELIMETER_FOR_DISPLAY)
        println("${winnerNames}가 최종 우승했습니다.")
    }
}
