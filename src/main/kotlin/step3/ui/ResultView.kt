package step3.ui

import step3.GameResult

object ResultView {
    fun display(gameResults: List<GameResult>) {
        gameResults.forEachIndexed { index, gameResult -> displayMoveResults(gameResult, isLastMove(index, gameResults.size)) }
    }

    private fun displayMoveResults(gameResult: GameResult, isLastMove: Boolean) {
        gameResult.moveResults.forEach { println("-".repeat(it.position)) }
        if (isLastMove) {
            println()
        }
    }

    private fun isLastMove(index: Int, listSize: Int): Boolean {
        return (index != listSize - 1)
    }
}
