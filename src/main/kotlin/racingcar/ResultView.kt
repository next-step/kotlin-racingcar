package racingcar

class ResultView {
    fun printGameHistory(gameResult: GameResults) {
        val gameResults = gameResult.gameResult
        gameResults.forEach { stage ->
            print(stage.joinToString("\n"))

            println("\n")
        }
    }

    fun printWinnerResult(winnerResult: String) {
        println(winnerResult)
    }
}
