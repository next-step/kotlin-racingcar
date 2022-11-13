package racing.view

class OutputView {
    fun printResultString() {
        println("실행 결과")
    }

    fun printResult(results: List<Int>) {
        results.map { i -> "-".repeat(i) }.forEach(::println)
        println()
    }
}
