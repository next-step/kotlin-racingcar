package racingcar_winner

import racingcar_winner.model.Game
import racingcar_winner.ui.InputView

private val inputView = InputView()

fun main() {
    val carNames = inputView.inputCarNames()
    val numberOfRound = inputView.inputNumberOfRound()

    val game = Game(numberOfRound, carNames)
    game.playGame()
}
