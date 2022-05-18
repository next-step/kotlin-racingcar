package carRacing

import carRacing.model.Game
import carRacing.util.Random
import carRacing.view.InputView
import carRacing.view.ResultView

fun main() {
    val carNameList: List<String> = InputView.carNameList()
    val numMovement: Int = InputView.numMovement()

    ResultView.printTitle()
    val randomGenerator: Random = Random.RandomGenerator()
    val game = Game(carNameList, numMovement, randomGenerator)
    game.run()
    ResultView.printResultRecord(carNameList, game.recordList)
    ResultView.printWinner(game.winner())
}
