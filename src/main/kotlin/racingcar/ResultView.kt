package racingcar

class ResultView {
    fun printGameResult(gameResult: GameResults) {
        val gameResults = gameResult.gameResult
        gameResults.forEach { stage ->
            stage.forEach { position ->
                repeat(position) {
                    print('-')
                }
                println()
            }
            println()
        }
    }
}