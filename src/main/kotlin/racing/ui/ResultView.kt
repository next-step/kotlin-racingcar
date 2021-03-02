package racing.ui

import racing.domain.Car
import racing.ui.model.RacingHistoryDTO
import racing.ui.model.RoundResultDTO

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

    fun printRacingHistory(racingHistory: RacingHistoryDTO) {
        val racingResults = racingHistory.roundResultDTOs
        racingResults.forEach { printRoundResult(it) }
    }

    private fun printRoundResult(roundResult: RoundResultDTO) {
        val carStates = roundResult.carStateDTOs
        carStates.forEach { (carName, position) ->
            printCarStates(carName, position)
        }
        println()
    }

    private fun printCarStates(carName: String, position: Int) {
        print("$carName : ")
        repeat(position) {
            print(SYMBOL_ONE_STEP)
        }
        println()
    }

    fun printWinners(cars: List<Car>) {
        val winnerNames = cars.joinToString(NAME_DELIMETER_FOR_DISPLAY) { it.name.name }
        println("${winnerNames}가 최종 우승했습니다.")
    }
}
