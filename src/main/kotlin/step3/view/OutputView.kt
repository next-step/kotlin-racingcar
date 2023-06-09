package step3.view

import step3.domain.CarPositions
import step3.domain.GameResult

object OutputView {
    fun printResult(gameResult: GameResult) {
        val positionsResult = gameResult.getPositionsResult()
        println("실행 결과")
        for (positions in positionsResult) {
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
