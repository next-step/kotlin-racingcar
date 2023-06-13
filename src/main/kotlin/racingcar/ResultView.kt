package racingcar

private const val RESULT_START_STRING = "\n실행 결과"

private const val MOVE_STRING = "-"

object ResultView {

    fun startPrintGame() = println(RESULT_START_STRING)

    fun printGameResult(gameResult: GameRecords) {
        gameResult.cars
            .forEach { println("${it.name} : ${MOVE_STRING.repeat(it.score)}") }
        println()
    }
}
