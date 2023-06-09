package step4

private const val RESULT_START_STRING = "\n실행 결과"

private const val MOVE_STRING = "-"

private const val WINNER_STRING = "가 최종 우승했습니다."

object ResultView {

    fun startPrintGame() {
        println(RESULT_START_STRING)
    }

    fun printGameResult(gameResult: GameRecords) {
        gameResult.cars.keys
            .forEach { println("${it.name} : ${MOVE_STRING.repeat(gameResult.cars[it]!!.score)}") }
        println()
    }

    fun printGameWinner(gameResult: GameRecords) {
        val max = gameResult.cars.values.maxBy { it.score }
        val winners = gameResult.cars.filter { it.value == max }.map { it.key.name }
        println("${winners.joinToString(", ")}$WINNER_STRING")
    }
}
