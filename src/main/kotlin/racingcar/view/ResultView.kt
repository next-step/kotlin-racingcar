package racingcar.view

interface ResultView {
    fun printResultTitle(title: String = "실행 결과") = print(title)
    fun printListResult(values: List<String>) {
        println()
        values.forEach { println(it) }
    }
}
