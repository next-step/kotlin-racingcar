package racingcar.view

import racingcar.domain.RacingGameResult

private const val RESULT_MESSAGE = "실행 결과"

fun printRacingGameResult(racingGameResults: List<RacingGameResult>) {
    println(RESULT_MESSAGE)
    for (racingGameResult in racingGameResults) {
        println(racingGameResult)
    }

    val winnersName = racingGameResults.last().getWinners().joinToString(separator = ", ") { it.name }
    println("${winnersName}가 최종 우승했습니다")
}
