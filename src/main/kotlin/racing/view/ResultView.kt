package racing.view

import racing.dto.RacingGameInfo

class ResultView {
    companion object {
        private const val PREFIX_TEMPLATE = "실행결과"
        private const val ROUND_SEPARATOR = "\n\n"
        private const val CAR_LINE_SEPARATOR = "\n"

        fun printToConsole(result: RacingGameInfo) {
            println(PREFIX_TEMPLATE)
            val consoleView = result.roundInfos.joinToString(ROUND_SEPARATOR) { round ->
                round.carInfos.joinToString(CAR_LINE_SEPARATOR) { car ->
                    "-".repeat(car.position)
                }
            }

            println(consoleView)
        }
    }
}
