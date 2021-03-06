package study.racingcar.ui

import study.racingcar.domain.RaceResult

object ResultView {
    private const val RESULT_COMMENT = "실행 결과"

    fun doResult(raceResults: List<RaceResult>) {
        println(RESULT_COMMENT)
        raceResults.forEach { println("${it.resultSymbols.joinToString("\n")}\n") }
    }
}
