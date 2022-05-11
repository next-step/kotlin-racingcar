package racingcar.presentation

import racingcar.business.dto.GameResult

class OutBoundView(
    private val printer: (String) -> Unit
) {
    fun displayResult(result: GameResult) {
        printer("실행 결과:\n")
        result.data.forEach(::displayResultDetails)
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
