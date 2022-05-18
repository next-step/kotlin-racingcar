package racingcar.presentation

import racingcar.domain.GameResult
import racingcar.domain.Record

class OutBoundView(
    private val printer: (String) -> Unit
) {
    fun displayResult(result: GameResult) {
        printer("실행 결과:\n")
        result.records.forEach(::displayResultDetails)
        printer("${result.winners.joinToString()}가 최종 우승했습니다.")
    }

    private fun displayResultDetails(result: List<Record>) {
        result.forEach { player ->
            printer(player.carName + " : ")
            repeat(player.position) {
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
