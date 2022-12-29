package application.racing

import domain.racing.Game
import util.racing.generator.RandomNumberGenerator
import view.racing.InputView
import view.racing.OutputView

fun main() {
    val carAmount = InputView.carAmountInput()
    val trial = InputView.trialInput()
    val game = Game(carAmount, trial)

    game.run(RandomNumberGenerator())

    OutputView.printResult(game.results)
}
