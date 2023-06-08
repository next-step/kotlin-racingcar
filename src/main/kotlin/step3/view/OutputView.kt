package step3.view

object OutputView {
    fun printResult() {
        println("실행 결과")
    }

    fun printByResults(results: List<Int>) {
        results.map { result ->
            println("-".repeat(result))
        }
        println()
    }
}
