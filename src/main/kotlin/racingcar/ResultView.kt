package racingcar

class ResultView {
    fun printGameHistory(gameResult: GameResults) {
        val gameResults = gameResult.gameResult
        gameResults.forEach { stage ->
            stage.forEach { eachResult ->
                println(eachResult)
            }
            println()
        }
    }

    fun printWinnerResult(winnerResult: String) {
        println(winnerResult)
    }
}