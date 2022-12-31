package application.racing

import domain.racing.Game
import util.racing.converter.NameInputConverter
import util.racing.generator.RandomNumberGenerator
import view.racing.InputView
import view.racing.OutputView

fun main() {
    val names = NameInputConverter.converter(InputView.carNamesInput())
    val trial = InputView.trialInput()
    val game = Game(names, trial)

    game.run(RandomNumberGenerator())

    OutputView.printResult(game.results)
}
