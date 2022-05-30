package racingcar.view

import racingcar.GameBoard

private fun showPositionBy(position: Int) = println(stringBy(position))

private fun stringBy(position: Int): String = "-".repeat(position)

class ResultView(private val gameBoard: GameBoard) {
    fun showAllPositionsByStep() {
        println("\n실행 결과")
        repeat(gameBoard.moveCount) {
            showPositionsBy(it + 1)
            println()
        }
    }

    private fun showPositionsBy(step: Int) = gameBoard.cars.forEach { showPositionBy(it.positionBy(step)) }
}
