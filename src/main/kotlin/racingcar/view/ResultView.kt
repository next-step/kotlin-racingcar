package racingcar.view

import racingcar.GameBoard

class ResultView(private val gameBoard: GameBoard) {
    private val steps = List(gameBoard.moveCount) { it + 1 }

    fun showAllPositionsByStep() {
        println("\n실행 결과")
        steps.forEach { step: Int ->
            showPositionsBy(step)
            println()
        }
    }

    private fun showPositionsBy(step: Int) = gameBoard.cars.forEach { showPositionBy(it.positionBy(step)) }

    companion object {
        private fun showPositionBy(position: Int) = println(stringBy(position))

        private fun stringBy(position: Int): String = "-".repeat(position)
    }
}
