package racing.ui

import racing.model.PositionHistory
import racing.model.TotalPositionHistory

class ResultView(private val carPositionHistory: TotalPositionHistory) {
    fun printResult() {
        printFirst()
        carPositionHistory.forEach { positionHistory ->
            printCarPosition(positionHistory)
        }
    }

    private fun printFirst() = println("실행 결과")

    private fun printCarPosition(positionHistory: PositionHistory) {
        positionHistory.forEach { position ->
            println(PRINT_VALUE.repeat(position))
        }
        println()
    }

    companion object {
        private const val PRINT_VALUE = "-"
    }
}
