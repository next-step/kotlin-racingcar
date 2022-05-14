package racingcar.view

import racingcar.dto.LapRecordResponse
import racingcar.dto.RacingGameRecordResponse

object ResultView {
    private const val RESULT = "실행 결과"
    private const val LOCATION_SYMBOL = "-"
    private const val CAR_DELIMITER = "\n"
    private const val LAP_DELIMITER = "\n\n"
    private const val CAR_NAME_POST_FIX = " "
    private const val WINNERS_DELIMITER = ", "
    private const val WINNERS_PRE_FIX = "\n"
    private const val WINNERS_POST_FIX = "가 최종 우승했습니다."

    fun print(response: RacingGameRecordResponse) {
        println(RESULT)
        printLapRecords(response.lapRecords)
        printWinners(response.winners)
    }

    private fun printLapRecords(lapRecords: List<LapRecordResponse>) {
        println(lapRecords.joinToString(LAP_DELIMITER) { lap(it) })
    }

    private fun lap(lapRecord: LapRecordResponse): String {
        return lapRecord.carRecords.joinToString(CAR_DELIMITER) { "${carName(it.carName)}${carLocation(it.location)}" }
    }

    private fun carName(name: String): String {
        return "${name}${CAR_NAME_POST_FIX}"
    }

    private fun carLocation(location: Int): String {
        return (1..location).joinToString("") { LOCATION_SYMBOL }
    }

    private fun printWinners(winners: List<String>) {
        val winnersText = winners.joinToString(WINNERS_DELIMITER)
        print(WINNERS_PRE_FIX + winnersText + WINNERS_POST_FIX)
    }
}
