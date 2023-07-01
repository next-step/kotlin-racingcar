package racingcar

import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carNames = InputView.requestCarNames()
    val round = InputView.requestRound()

    val racingGame = RacingGame(round, carNames)
    racingGame.run()

    val histories = racingGame.getHistories()
    ResultView.printHistory(histories)

    val winners = racingGame.getWinnerNames()
    ResultView.printWinners(winners)
}
