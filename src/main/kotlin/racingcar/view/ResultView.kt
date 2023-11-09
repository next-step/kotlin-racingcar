package racingcar.view

import racingcar.domain.GameResult

private const val RESULT_MESSAGE = "실행 결과"

fun printGameResult(gameResults: List<GameResult>) {
    println(RESULT_MESSAGE)
    for (gameResult in gameResults) {
        println(gameResult)
    }

    val winnersName = gameResults.last().getWinners().joinToString(separator = ", ") { it.name }
    println("${winnersName}가 최종 우승했습니다")
}
