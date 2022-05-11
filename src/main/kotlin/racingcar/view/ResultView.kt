package racingcar.view

import racingcar.dto.RacingGameResponse

object ResultView {
    private const val RESULT = "실행 결과"
    private const val LOCATION_SYMBOL = "-"
    private const val CAR_DELIMITER = "\n"
    private const val LAP_DELIMITER = "\n\n"
    private const val CAR_NAME_POST_FIX = " "
    private const val WINNERS_DELIMITER = ", "
    private const val WINNERS_POST_FIX = "가 최종 우승했습니다."

    fun print(response: RacingGameResponse) {
        println(RESULT)
        println(lapReports(response.lapReports))
        println()
        print(winners(response.winners))
    }

    private fun lapReports(lapReports: List<List<Pair<String, Int>>>): String {
        return lapReports.joinToString(LAP_DELIMITER) { lap(it) }
    }

    private fun lap(lapReports: List<Pair<String, Int>>): String {
        return lapReports.joinToString(CAR_DELIMITER) { "${carName(it.first)}${carLocation(it.second)}" }
    }

    private fun carName(name: String): String {
        return "${name}${CAR_NAME_POST_FIX}"
    }

    private fun carLocation(location: Int): String {
        return (1..location).joinToString("") { LOCATION_SYMBOL }
    }

    private fun winners(winners: List<String>): String {
        val winnersText = winners.joinToString(WINNERS_DELIMITER)
        return winnersText + WINNERS_POST_FIX
    }
}
