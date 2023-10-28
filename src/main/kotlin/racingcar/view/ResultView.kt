package racingcar.view

object ResultView {
    fun printResult(name: String, count: Int) {
        print("$name: ")
        repeat(count) {
            print("-")
        }
        println()
    }

    fun printEmptyLine() = println()
}
