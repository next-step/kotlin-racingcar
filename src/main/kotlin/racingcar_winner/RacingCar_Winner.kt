package racingcar_winner

import racingcar_winner.model.Game
import racingcar_winner.ui.InputView
import racingcar_winner.ui.Outputview

fun main() {
    val inputView = InputView()
    val outputView = Outputview()
    val carNames = inputView.inputCarNames()
    val numberOfRound = inputView.inputNumberOfRound()

    val game = Game(numberOfRound, carNames)

    game.playGame()
    outputView.printProgressOfCars(game.getGameRecord())
    outputView.printWinner(game.getGameWinner())

}
