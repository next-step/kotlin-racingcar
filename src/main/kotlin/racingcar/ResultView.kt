package racingcar

class ResultView {
    fun printGameResult(gameResult: List<List<Int>>) {
        gameResult.forEach { stage ->
            stage.forEach { position ->
                for (i in 0 until position) {
                    print('-')
                }
                println()
            }
            println()
        }
    }
}