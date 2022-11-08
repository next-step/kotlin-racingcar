package racingcar

class ResultView {
    fun printStatus(number: Int) {
        for (i in 1..number) {
            print("-")
        }
        println()
    }
}
