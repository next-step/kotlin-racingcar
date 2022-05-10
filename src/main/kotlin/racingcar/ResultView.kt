package racingcar

class ResultView {
    fun printGameResult(gameResult: GameResults) {
        val gameResults = gameResult.gameResult
        gameResults.forEach { stage ->
            stage.forEach { eachResult ->
                println(eachResult)
            }
            println()
        }
    }
}