package racingcar.presentation

class OutBoundView(
    private val console: (String) -> Unit
) {
    fun displayResult(result: List<List<Int>>) {
        console("실행 결과:\n")
        result.forEach(::displayResultDetails)
    }

    private fun displayResultDetails(result: List<Int>) {
        result.forEach { player ->
            repeat(player) {
                console(DISPLAY_MOVEMENT)
            }
            disPlayEmptyLine()
        }
        disPlayEmptyLine()
    }

    private fun disPlayEmptyLine() = console("\n")

    companion object {
        private const val DISPLAY_MOVEMENT = "-"
    }
}
