package racing.ui

import racing.model.PositionHistory
import racing.model.TotalPositionHistory

class ResultView(private val totalPositionHistory: TotalPositionHistory) {
    fun printResult() {
        printFirst()
        totalPositionHistory.forEach { positionHistory ->
            printCarMoveResult(positionHistory)
        }
    }

    private fun printFirst() = println("실행 결과")

    private fun printCarMoveResult(positionHistory: PositionHistory) {
        positionHistory.forEach { moveResult ->
            print("${moveResult.name} : ")
            println(PRINT_VALUE.repeat(moveResult.position))
        }
        println()
    }

    companion object {
        private const val PRINT_VALUE = "-"
    }
}
