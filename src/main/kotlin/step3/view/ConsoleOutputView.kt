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

    override fun showWinner(winnerNames: List<String>) {
        println("${winnerNames.joinToString()}가 최종 우승했습니다.")
    }
}
