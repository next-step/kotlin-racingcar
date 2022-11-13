package racing.ui

object OutputView {
    private const val DASH_LINE = "-"

    fun printOutputLetter() = println("실행 결과")

    fun printCarCollection(positions: List<Int>) = positions.forEach {
        printCarLine(it)
        println()
    }

    private fun printCarLine(position: Int) = println(DASH_LINE.repeat(position))
}
