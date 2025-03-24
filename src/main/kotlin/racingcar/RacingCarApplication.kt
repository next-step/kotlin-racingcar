package racingcar

import racingcar.game.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputCarNames = InputView.requestCarNames()
    val inputNumberOfRounds = InputView.requestNumberOfRounds()

    val racingGame = RacingGame(inputCarNames, inputNumberOfRounds)
    racingGame.start()

    OutputView.printResult(racingGame.currentResult)
    OutputView.printWinners(racingGame.winningCarNames)
}
