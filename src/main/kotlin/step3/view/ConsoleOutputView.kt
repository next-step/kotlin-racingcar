package step3.view

import step3.CurrentCarStatus

class ConsoleOutputView : OutputView {
    override fun showResultTitle() {
        println("\n실행 결과")
    }

    override fun showStatus(carStatuses: List<CurrentCarStatus>) {
        carStatuses.forEach {
            val distanceBar = "-".repeat(it.movedDistance.toInt())
            println("${it.carName} : $distanceBar")
        }
        println()
    }
}
