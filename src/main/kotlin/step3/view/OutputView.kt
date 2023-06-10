package step3.view

import step3.Distance

object OutputView {
    fun showResultTitle() {
        println("\n실행 결과")
    }

    fun showStatus(distanceResult: List<Distance>) {
        distanceResult.forEach {
            val distanceView = "-".repeat(it.toInt())
            println(distanceView)
        }
        println()
    }
}
