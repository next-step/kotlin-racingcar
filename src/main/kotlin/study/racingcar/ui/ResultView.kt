package study.racingcar.ui

import study.racingcar.domain.Cars
import study.racingcar.domain.RaceResults
import study.racingcar.domain.Winners

object ResultView {
    private const val RESULT_COMMENT = "실행 결과"
    private const val WINNER_COMMENT = "가 최종우승했습니다."

    private fun doResult(resultCars: Cars) {
        println("$resultCars\n")
    }

    fun doResults(raceResults: RaceResults) {
        println(RESULT_COMMENT)
        raceResults.raceResultCars.forEach {
            doResult(it)
        }
        println("${raceResults.winners}$WINNER_COMMENT")
    }
}
