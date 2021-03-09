package study.racingcar.ui

import study.racingcar.domain.Cars
import study.racingcar.domain.Winners

object ResultView {
    private const val RESULT_COMMENT = "실행 결과"
    private const val WINNER_COMMENT = "가 최종우승했습니다."

    fun doResult(raceResults: List<Cars>, winners: Winners) {
        println(RESULT_COMMENT)
        raceResults.forEach { println("${it}\n") }
        println("$winners$WINNER_COMMENT")
    }
}
