package racing.ui

object OutputView {
    private const val DASH_LINE = "-"

    fun printTitle() = println("실행 결과")

    fun printCarPosition(positions: List<Int>) = positions.forEach {
        printCarLine(it)
    }

    private fun printCarLine(position: Int) = println(DASH_LINE.repeat(position))
}
