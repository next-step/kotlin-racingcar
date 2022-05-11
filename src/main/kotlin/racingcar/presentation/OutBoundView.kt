package racingcar.presentation

class OutBoundView(
    private val printer: (String) -> Unit
) {
    fun displayResult(result: List<List<Int>>) {
        printer("실행 결과:\n")
        result.forEach(::displayResultDetails)
    }

    private fun displayResultDetails(result: List<Int>) {
        result.forEach { player ->
            repeat(player) {
                printer(DISPLAY_MOVEMENT)
            }
            disPlayEmptyLine()
        }
        disPlayEmptyLine()
    }

    private fun disPlayEmptyLine() = printer("\n")

    companion object {
        private const val DISPLAY_MOVEMENT = "-"
    }
}
