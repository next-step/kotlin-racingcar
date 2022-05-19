package racingcar.view

import racingcar.dto.MoveResults

object ResultView {
    private const val DASH_VIEW = "-"
    private const val WINNER_NAME_LINKER = ","

    fun showRaceWinner(winners: List<String>) {
        winners.toString()
        println("${toWinnerView(winners)}가 최종 우승했습니다.")
    }

    private fun toWinnerView(winners: List<String>): String {
        val firstWinner = winners.first()
        val leftWinners = winners.takeLast(winners.size - 1)

        var winnerNameView = firstWinner
        leftWinners.forEach { winner ->
            winnerNameView = winnerNameView.plus("$WINNER_NAME_LINKER $winner")
        }
        return winnerNameView
    }

    fun showAllRacingRecords(results: List<MoveResults>) {
        results.forEach(::showEachRecord)
    }

    private fun showEachRecord(moveResults: MoveResults) {
        moveResults.data.map { result ->
            showResultView(result.carName, getDashView(result.moveDistance))
        }
        println()
    }

    private fun showResultView(carName: String, dash: String) {
        println("$carName : $dash")
    }

    private fun getDashView(moveDistance: Int): String {
        return DASH_VIEW.repeat(moveDistance)
    }
}
