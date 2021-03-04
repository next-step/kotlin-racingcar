package racingcar.ui

class ResultView {
    fun printResult(positions: List<Int>) {
        positions.map { position ->
            println(POSITION_DISPLAY_BAR.repeat(position))
        }
        println()
    }

    companion object {
        const val POSITION_DISPLAY_BAR: String = "-"
    }
}
