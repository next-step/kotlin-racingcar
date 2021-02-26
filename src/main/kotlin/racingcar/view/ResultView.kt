package racingcar.view

class ResultView(val score: Int) {
    fun printResult() {
        for (i in 1..score) {
            print("-")
        }
        println()
    }
}
