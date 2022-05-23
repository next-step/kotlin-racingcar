package racingcar

import racingcar.view.ResultView

fun main() {
    val gameBoard = GameBoard()
    val resultView = ResultView(gameBoard.cars, gameBoard.stepSize)
    resultView.showAllPositionsByStep()
}
