package racing.ui

private const val DISPLAY_MARK = "-"

object ResultView {

    fun printResult() {
        println("실행 결과")
    }

    fun print(positions: List<Int>) {
        positions.forEach { position ->
            println(DISPLAY_MARK.repeat(position))
        }
        println()
    }
}
