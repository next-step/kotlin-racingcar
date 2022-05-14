package carRacing

import carRacing.controller.Game
import carRacing.view.InputView
import carRacing.view.ResultView

fun main() {
    val carNameList: List<String> = InputView.carNameList()
    val numMovement: Int = InputView.numMovement()

    ResultView.printTitle()
    val game = Game(carNameList, numMovement)
    game.run()
    ResultView.printResultRecord(carNameList, game.recordList)
    ResultView.printWinner(game.winner())
}
