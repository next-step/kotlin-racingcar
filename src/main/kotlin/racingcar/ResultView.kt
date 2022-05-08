package racingcar

class ResultView {
    fun printGameResult(gameResult: List<List<Int>>) {
        gameResult.forEach { stage ->
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