package step3.view

import step3.Distance

class ConsoleOutputView : OutputView {
    override fun showResultTitle() {
        println("\n실행 결과")
    }

    override fun showStatus(distanceResult: List<Distance>) {
        distanceResult.forEach {
            val distanceView = "-".repeat(it.toInt())
            println(distanceView)
        }
        println()
    }
}
