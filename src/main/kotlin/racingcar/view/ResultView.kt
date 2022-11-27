package racingcar.view

import racingcar.domain.RaceResult
import racingcar.exception.CannotFindWinnerException

object ResultView {
    fun printResult(raceResult: RaceResult) {
        printHistoryByRound(raceResult)
        printWinners(raceResult)
    }

    private fun printHistoryByRound(raceResult: RaceResult) {
        raceResult.roundHistories.forEach { roundHistory ->
            printRoundResult(roundHistory.round)
            printRoundCarPositions(roundHistory.carInfos)
            println("\n")
        }
    }

    private fun printRoundResult(round: Int) {
        println("[${round + 1} 라운드 결과]")
    }

    private fun printRoundCarPositions(carInfos: List<Pair<String, Int>>) {
        carInfos.forEach { carInfo -> println("${carInfo.first}: ${"-".repeat(carInfo.second)} \r") }
    }

    private fun printWinners(raceResult: RaceResult) {
        val winners = raceResult.getWinners()

        try {
            if (winners.isNullOrEmpty()) throw CannotFindWinnerException()
            val winnerNames = winners.joinToString(separator = ", ")

            println("${winnerNames}가 최종 우승했습니다.")
        } catch (e: CannotFindWinnerException) {
            println(e.message)
        }
    }
}
