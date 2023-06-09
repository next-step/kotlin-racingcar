package racingcar

private const val RESULT_START_STRING = "\n실행 결과"

private const val MOVE_STRING = "-"

object ResultView {

    fun startPrintGame() = println(RESULT_START_STRING)

    fun printGameResult(gameResult: GameRecords) {
        for (i in 0 until gameResult.records.size) {
            println(MOVE_STRING.repeat(gameResult.records[i]))
        }
        println()
    }
}
