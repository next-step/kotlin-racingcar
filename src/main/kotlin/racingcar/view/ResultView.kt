package racingcar.view

import racingcar.dto.RacingGameResponse

class ResultView {
    companion object {
        private const val RESULT = "실행 결과"
        private const val LOCATION_SYMBOL = "-"
        private const val CAR_DELIMITER = "\n"
        private const val LAP_DELIMITER = "\n\n"

        fun print(response: RacingGameResponse) {
            println(RESULT)
            print(lapReports(response))
        }

        private fun lapReports(response: RacingGameResponse): String {
            return response.lapReports
                .joinToString(LAP_DELIMITER) { lap(it) }
        }

        private fun lap(lapReports: List<Int>): String {
            return lapReports.joinToString(CAR_DELIMITER) { carLocation(it) }
        }

        private fun carLocation(location: Int): String {
            return (1..location).joinToString("") { LOCATION_SYMBOL }
        }
    }
}
