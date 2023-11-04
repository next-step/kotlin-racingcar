package racingcar.view

import racingcar.model.Car
import racingcar.model.RacingGameResult
import racingcar.model.log.CarLog
import racingcar.model.log.RoundLog

class RacingcarGameResultView {

    fun printGameResult(result: RacingGameResult) {
        val winners = result.winners
        val roundLogs = result.roundLogs

        printGameStart()
        printRoundLogs(roundLogs)
        printGameWinners(winners)
    }

    private fun printGameStart() {
        println("실행 결과")
    }

    private fun printRoundLogs(roundLogs: List<RoundLog>) {
        roundLogs.forEach {
            printCarLogs(it.carLogs)
        }
    }

    private fun printCarLogs(carLogs: List<CarLog>) {
        carLogs.forEach {
            printCarLog(it)
        }
        println()
    }

    private fun printCarLog(carLog: CarLog) {
        val distance = carLog.distance + 1

        println("${carLog.name} : " + CAR_DISTANCE_CHARACTER.repeat(distance))
    }

    private fun printGameWinners(winners: List<Car>) {
        val winnersNameString = winners.joinToString(WINNER_DISPLAY_SEPARATOR) { it.name }

        println("${winnersNameString}가 최종 우승했습니다.\n")
    }

    companion object {
        private const val CAR_DISTANCE_CHARACTER = "-"
        private const val WINNER_DISPLAY_SEPARATOR = ", "
    }
}
