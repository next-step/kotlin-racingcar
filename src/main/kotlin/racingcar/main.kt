package racingcar

import racingcar.view.ResultView

fun main() {
    val gameBoard = GameBoard()
    val resultView = ResultView(gameBoard)
    resultView.showAllPositionsByStep()
}
