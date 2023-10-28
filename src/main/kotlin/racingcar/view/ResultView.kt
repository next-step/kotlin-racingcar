package racingcar.view

object ResultView {
    fun printInitial() {
        println("실행 결과")
    }

    fun printResult(name: String, count: Int) {
        print("$name: ")
        repeat(count) {
            print("-")
        }
        println()
    }

    fun printEmptyLine() = println()
}
