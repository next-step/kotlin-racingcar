package step3.ui

import step3.GameResult

object ResultView {
    fun display(gameResults: List<GameResult>) {
        gameResults
            .forEachIndexed { index, gameResult ->
                gameResult.labResult
                    .forEach { println("-".repeat(it.position)) }
                if (index != gameResults.size - 1) {
                    println()
                }
            }
    }
}
