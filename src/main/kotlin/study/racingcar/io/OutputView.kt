package study.racingcar.io

import study.racingcar.racing.RacingResult
import study.racingcar.racing.Record

object OutputView {
    fun printResult(result: RacingResult) {
        result.rounds
            .forEach { round: List<Record> ->
                printByRound(round)
                printEndOfTurn()
            }
    }

    fun printWinners(result: RacingResult) {
        val winnersName = result.getWinners()
            .joinToString(",") { winner ->
                winner.name
            }

        println("${winnersName}가 최종 우승했습니다.")
    }

    private fun printByRound(round: List<Record>) {
        round.forEach { record ->
            println("${record.name} : ${getLocationSymbols(record.location)}")
        }
    }

    private fun getLocationSymbols(location: Int): String {
        return LOCATION_SYMBOL.repeat(location)
    }

    private fun printEndOfTurn() {
        return println()
    }

    private const val LOCATION_SYMBOL = "-"
}
