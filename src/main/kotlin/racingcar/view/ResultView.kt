package racingcar.view

import racingcar.model.RacingGame

object ResultView {

    fun printRacingProcess(racingGame: RacingGame) {
        println("실행 결과")

        val chunkedRacingHistory = racingGame.movingDistanceHistory.chunked(racingGame.racingCars.size)
        printRacingStep(racingGame.racingCars.map { it.name }, chunkedRacingHistory)
    }

    fun printRacingWinner(winners: List<String>) {
        println("${winners.joinToString()}가 최종 우승했습니다.")
    }

    private fun printRacingStep(racingCarNames: List<String>, chunkedRacingHistory: List<List<Int>>) {
        repeat(chunkedRacingHistory.size) { tryCnt ->
            printRacingCycle(racingCarNames, chunkedRacingHistory, tryCnt)
            println()
        }
    }

    private fun printRacingCycle(racingCarNames: List<String>, chunkedRacingHistory: List<List<Int>>, tryCnt: Int) {
        repeat(racingCarNames.size) { racingCnt ->
            println("${racingCarNames[racingCnt]} : ${"-".repeat(chunkedRacingHistory[tryCnt][racingCnt])}")
        }
    }
}
