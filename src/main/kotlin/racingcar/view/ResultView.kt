package racingcar.view

import racingcar.domain.RaceResult
import racingcar.domain.RoundHistory

class ResultView {
    companion object {
        fun printResult(raceResult: RaceResult) {
            printHistoryByRound(raceResult)
        }

        private fun printHistoryByRound(raceResult: RaceResult) {
            raceResult.groupByRound().forEach { (round, roundHistories) ->
                printRoundResult(round)
                roundHistories.forEach { history -> printRoundHistoryResult((history)) }
                println("\n")
            }
        }

        private fun printRoundResult(round: Int) {
            println("[${round + 1} 라운드 결과]")
        }

        private fun printRoundHistoryResult(roundHistory: RoundHistory) {
            val historyInfo = "${roundHistory.carName}: " + "-".repeat(roundHistory.carPosition)

            println("$historyInfo \r")
        }
    }
}
