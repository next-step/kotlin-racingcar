package study.racingcar.view

import study.racingcar.race.RaceResult

object ResultView {
    fun printRaceResults(raceResults: List<RaceResult>) {
        println("\n실행 결과")
        raceResults.forEach { raceResult ->
            printCarState(raceResult)
        }
    }
    private fun printCarState(raceResult: RaceResult) {
        raceResult.attemptResults.forEach { carState ->
            println("${carState.name} : ${carState.getVisualPosition()}")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
