package racingcar.view

import racingcar.domain.RaceResult

object ResultView {
    fun printResult(raceResult: RaceResult) {
        printHistoryByRound(raceResult)
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
}
