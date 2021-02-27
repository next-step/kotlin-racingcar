package racingcar.view

private const val LINE_SEPARATOR = "========================"

class ResultViews(private val resultViews: List<ResultView>) {
    fun printResults() {
        resultViews.forEach { resultView: ResultView -> resultView.printResult() }
        println(LINE_SEPARATOR)
    }
}
