package racingcar.view

private const val LINE_SEPARATOR = "========================"

class ResultViews(var resultViews: List<ResultView>) {
    fun printResultS() {
        resultViews.forEach { resultView: ResultView -> resultView.printResult() }
        println(LINE_SEPARATOR)
    }
}
