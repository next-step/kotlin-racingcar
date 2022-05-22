package racing.ui

import racing.domain.MoveResultHistory
import racing.domain.MoveResults

class ResultView(private val moveResultHistory: MoveResultHistory) {
    fun printResult() {
        printFirst()
        moveResultHistory.history.forEach { history ->
            printCarMoveResult(history)
        }
        printWinnersName()
    }

    private fun printFirst() = println("실행 결과")

    private fun printCarMoveResult(moveResults: MoveResults) {
        moveResults.results.forEach { moveResult ->
            print("${moveResult.name.value} : ")
            println(PRINT_VALUE.repeat(moveResult.position.value))
        }
        println()
    }

    private fun printWinnersName() {
        println(
            moveResultHistory.getWinnerNames().names.joinToString(
                separator = ", ",
                postfix = "가 최종 우승했습니다."
            ) { name -> name.value }
        )
    }

    companion object {
        private const val PRINT_VALUE = "-"
    }
}
