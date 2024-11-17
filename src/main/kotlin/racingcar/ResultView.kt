package racingcar

object ResultView {
    private const val RESULT_TITLE_MESSAGE = "실행 결과"
    private const val MOVE_SYMBOL = "-"

    fun printResultTitle() {
        println(RESULT_TITLE_MESSAGE)
    }

    fun printRaceResult(cars: List<Car>) {
        val sb = StringBuilder()
        cars.forEach { sb.appendLine(MOVE_SYMBOL.repeat(it.moveCount)) }
        println(sb)
    }
}
