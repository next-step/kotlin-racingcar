package racingcar.view

class ResultView {
    fun printResult(result: List<String>) {
        result.forEach { println(it) }
        println()
    }
}
