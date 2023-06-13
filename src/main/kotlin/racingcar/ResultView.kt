package racingcar

private const val RESULT_START_STRING = "\n실행 결과"
private const val MOVE_STRING = "-"
private const val WINNER_STRING = "가 최종 우승했습니다."

object ResultView {

    fun startPrintGame() = println(RESULT_START_STRING)

    fun printGameResult(gameResult: GameRecords) {
        gameResult.cars
            .forEach { println("${it.name} : ${MOVE_STRING.repeat(it.score)}") }
        println()
    }

    fun printGameWinner(gameResult: GameRecords) {
        val max = gameResult.cars.maxBy { it.score }.score
        val winners = gameResult.cars.filter { it.score == max }.map { it.name }
        println("${winners.joinToString(", ")}$WINNER_STRING")
    }
}
