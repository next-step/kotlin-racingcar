package racingcar.view

class ResultViews(var resultViews: List<ResultView>) {
    fun printResultS() {
        resultViews.forEach { resultView: ResultView -> resultView.printResult() }
        println("----------------------")
    }
}
