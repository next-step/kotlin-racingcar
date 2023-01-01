package racingcar.ui.view

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RaceResult

object ResultView {
    fun printRaceResult(raceResult: RaceResult, winners: List<Car>) {
        printHistoryByRound(raceResult)
        printWinners(winners)
    }

    private fun printHistoryByRound(raceResult: RaceResult) {
        raceResult.roundHistories.forEach { roundHistory ->
            printRoundResult(roundHistory.round)
            printRoundCarPositions(roundHistory.cars)
            println("\n")
        }
    }

    private fun printRoundResult(round: Int) {
        println("[${round + 1} 라운드 결과]")
    }

    private fun printRoundCarPositions(cars: Cars) {
        cars.getPositions().forEach {
            println("${it.key}: ${"-".repeat(it.value)}")
        }
    }

    private fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(separator = ", ") { it.name }

        println("${winnerNames}가 최종 우승했습니다.")
    }
}
