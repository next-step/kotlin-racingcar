package study.racingcar.view

import study.racingcar.domain.car.Car
import study.racingcar.domain.racing.RacingResult
import study.racingcar.domain.racing.Record

class OutputView {
    fun printResult(result: RacingResult) {
        result.rounds
            .forEach { round: List<Record> ->
                printByRound(round)
                printEndOfTurn()
            }
    }

    fun printWinners(winners: List<Car>) {
        val winnersName = winners.joinToString(",")

        println("${winnersName}가 최종 우승했습니다.")
    }

    private fun printByRound(round: List<Record>) {
        round.forEach { println("${it.name} : ${getLocationSymbols(it.location)}") }
    }

    private fun getLocationSymbols(location: Int): String {
        return LOCATION_SYMBOL.repeat(location)
    }

    private fun printEndOfTurn() {
        return println()
    }

    companion object {
        private const val LOCATION_SYMBOL = "-"
    }
}
