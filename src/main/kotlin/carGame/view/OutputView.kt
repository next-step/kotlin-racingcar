package carGame.view

import carGame.domain.CarPositions
import carGame.domain.GameResult

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
