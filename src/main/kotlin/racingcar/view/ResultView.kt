package racingcar.view

import racingcar.model.RacingGame

object ResultView {

    fun printRacingProcess(racingGame: RacingGame) {
        println("실행 결과")

        printRacingStep(
            racingCarNames = racingGame.racingCars.map { it.name },
            racingHistories = racingGame.movingDistanceHistory.chunked(racingGame.racingCars.size)
        )
    }

    fun printRacingWinner(winners: List<String>) {
        println("${winners.joinToString()}가 최종 우승했습니다.")
    }

    private fun printRacingStep(racingCarNames: List<String>, racingHistories: List<List<Int>>) {
        repeat(racingHistories.size) {
            printRacingCycle(racingCarNames, racingHistories[it])
            println()
        }
    }

    private fun printRacingCycle(racingCarNames: List<String>, racingHistory: List<Int>) {
        repeat(racingCarNames.size) {
            println("${racingCarNames[it]} : ${"-".repeat(racingHistory[it])}")
        }
    }
}
