package racingcar.view

private const val ONE_BLOCK = "-"
private const val SEPARATOR = " | "

class ResultView(private val carName: String, private val score: Int) {
    fun printResult() {
        print(carName)
        print(SEPARATOR)

        for (i in 1..score) {
            print(ONE_BLOCK)
        }

        println()
    }
}
