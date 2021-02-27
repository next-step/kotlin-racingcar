package racingcar.view

private const val ONE_BLOCK = "-"

class ResultView(private val score: Int) {
    fun printResult() {
        for (i in 1..score) {
            print(ONE_BLOCK)
        }
        println()
    }
}
