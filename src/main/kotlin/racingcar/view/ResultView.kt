package racingcar.view

import racingcar.domain.RaceResult

object ResultView {
    fun printResult(raceResult: RaceResult) {
        printHistoryByRound(raceResult)
    }

    private fun printHistoryByRound(raceResult: RaceResult) {
        raceResult.roundHistories.forEach { roundHistory ->
            printRoundResult(roundHistory.round)
            printRoundCarPositions(roundHistory.carPositions)
            println("\n")
        }
    }

    private fun printRoundResult(round: Int) {
        println("[${round + 1} 라운드 결과]")
    }

    private fun printRoundCarPositions(carPositions: List<Int>) {
        carPositions.forEach { position -> println("${"-".repeat(position)} \r") }
    }
}
