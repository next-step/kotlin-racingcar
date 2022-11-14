package racing

import racing.domain.RacingGame
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val input = InputView.input()
    val game = RacingGame.create(input.numberOfCar, input.round)
    ResultView.printToConsole(game.play())
}
