package step3.view

import step3.domain.CarPositions
import step3.domain.GameResult

object OutputView {
    fun printResult(gameResult: GameResult) {
        val result = gameResult.getResult()
        println("실행 결과")
        for (positions in result) {
            printCarPositions(positions)
        }
    }

    private fun printCarPositions(positions: CarPositions) {
        for (position in positions.getPositions()) {
            println("-".repeat(position))
        }
        println()
    }
}
