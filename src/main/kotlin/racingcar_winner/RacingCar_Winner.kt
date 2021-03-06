package racingcar_winner

import racingcar_winner.model.Game
import racingcar_winner.ui.InputView
import racingcar_winner.ui.Outputview

private val inputView = InputView()
private val outputView = Outputview()

fun main() {
    val carNames = inputView.inputCarNames()
    val numberOfRound = inputView.inputNumberOfRound()
    val game = Game(carNames)

    playGame(game, numberOfRound)
}

fun playGame(game: Game, numberOfRound: Int) {
    repeat(numberOfRound) {
        outputView.printOneRoundProgress(game.playOneRound())
    }
    outputView.printWinner(game.getGameWinner())
}
