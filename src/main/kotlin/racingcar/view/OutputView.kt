package racingcar.view

import racingcar.domain.CarGamePosition

private const val RESULT_TITLE = "실행 결과"
private const val POSITION = "-"
private const val WINNER_DELIMITER = ","

fun printResultTitle() = println(RESULT_TITLE)

fun printCurrentResult(carGamePositions: List<CarGamePosition>) {
    carGamePositions.forEach { println("${it.name} : ${POSITION.repeat(it.position)}") }
    println()
}

fun printWinner(winner: List<String>) {
    println("${winner.joinToString(WINNER_DELIMITER)}가 최종 우승했습니다.")
}
