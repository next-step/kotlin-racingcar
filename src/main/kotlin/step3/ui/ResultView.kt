package step3.ui

import step3.dto.TrackResult

object ResultView {
    fun display(gameResults: List<TrackResult>) {
        gameResults.forEachIndexed { index, gameResult -> displayMoveResults(gameResult, isLastMove(index, gameResults.size)) }
    }

    private fun displayMoveResults(gameResult: TrackResult, isLastMove: Boolean) {
        gameResult.moveResults.forEach { println("${it.car.name} : " + "-".repeat(it.position)) }
        println()
        if (isLastMove) {
            displayWinner(gameResult)
        }
    }

    private fun isLastMove(index: Int, listSize: Int): Boolean {
        return (index == listSize - 1)
    }

    private fun displayWinner(gameResult: TrackResult) {
        val winners = gameResult.getWinners().joinToString(", ") { it.name }
        println("${winners}가 최종 우승했습니다.")
    }
}
