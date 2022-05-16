package racing.ui

import racing.model.PositionHistory
import racing.model.TotalPositionHistory

class ResultView(private val totalPositionHistory: TotalPositionHistory) {
    fun printResult() {
        printFirst()
        totalPositionHistory.forEach { positionHistory ->
            printCarMoveResult(positionHistory)
        }
        printWinnersName()
    }

    private fun printFirst() = println("실행 결과")

    private fun printCarMoveResult(positionHistory: PositionHistory) {
        positionHistory.forEach { moveResult ->
            print("${moveResult.name.name} : ")
            println(PRINT_VALUE.repeat(moveResult.position.position))
        }
        println()
    }

    private fun printWinnersName() {
        println(
            totalPositionHistory.findWinnersName().names.joinToString(
                separator = ", ",
                postfix = "가 최종 우승했습니다."
            ) { it.name }
        )
    }

    companion object {
        private const val PRINT_VALUE = "-"
    }
}
