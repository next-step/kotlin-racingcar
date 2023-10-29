package study.view

import study.domain.RaceResult

object ResultView {
    fun showRaceResult(raceResult: RaceResult) {
        println("실행 결과")

        raceResult.getRounds().forEach { round ->
            println("${round}번째 시도")

            val carPositions = raceResult.getCarPositions(round)
            carPositions?.forEach { carPosition ->
                repeat(carPosition) {
                    print("-")
                }
                println()
            }
            println()
        }
    }
}
