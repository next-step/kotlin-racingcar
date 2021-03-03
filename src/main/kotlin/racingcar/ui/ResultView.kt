package racingcar.ui

class ResultView(private val positions: List<Int>) {
    fun printResult() {
        positions.map { position ->
            println(POSITION_DISPLAY_BAR.repeat(position))
        }
        println()
    }

    companion object {
        const val POSITION_DISPLAY_BAR: String = "-"
    }
}
