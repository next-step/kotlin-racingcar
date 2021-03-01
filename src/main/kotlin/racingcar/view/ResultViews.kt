package racingcar.view

private const val LINE_SEPARATOR = "========================"

class ResultViews(private val resultViews: List<ResultView>) {
    fun printResults() {
        resultViews.forEach(ResultView::printResult)
        println(LINE_SEPARATOR)
    }
}
