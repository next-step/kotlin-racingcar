package racingcar

class ResultView {
    fun view(position: Int) = repeat(position + 1) { print(POSITION_TEXT) }
    fun newLine() = println(NEWLINE_TEXT)

    companion object {
        const val POSITION_TEXT = "-"
        const val NEWLINE_TEXT = ""
    }
}
