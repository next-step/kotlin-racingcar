package racingcar

const val RESULT_MESSAGE = "실행 결과"

fun printGameResult(gameResults: List<GameResult>) {
    println(RESULT_MESSAGE)
    for (gameResult in gameResults) {
        println(gameResult)
    }
}
