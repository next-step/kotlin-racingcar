package racingcar

import racingcar.strategy.RandomMovingStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carCount = InputView.readCarNames()
    val tryCount = InputView.readTryCount { InputValidator.isValidTryCount(it) }
    val gameHost = RacingGame(carCount, tryCount, RandomMovingStrategy())

    ResultView.printResultTitle()
    while (gameHost.isProgress()) {
        val movingStatus = gameHost.startRound()
        ResultView.printMovingStatus(movingStatus)
    }

    ResultView.printWinners(gameHost.findWinners())
}
