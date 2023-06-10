package racingcar.view

private const val RESULT_TITLE = "실행 결과"
private const val POSITION = "-"
private const val WINNER_DELIMITER = ","

fun printResultTitle() = println(RESULT_TITLE)

fun printCurrentResult(carPositions: List<Pair<String, Int>>) {
    carPositions.forEach { println("${it.first} : ${POSITION.repeat(it.second)}") }
    println()
}

fun printWinner(winner: List<String>) {
    println("${winner.joinToString(WINNER_DELIMITER)}가 최종 우승했습니다.")
}
