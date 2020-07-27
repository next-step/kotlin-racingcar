package racingcar

import racingcar.strategy.RandomMovingStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carCount = InputView.readCarCount { InputValidator.isValidCarCount(it) }
    val tryCount = InputView.readTryCount { InputValidator.isValidTryCount(it) }
    val gameHost = RacingGame(carCount, tryCount, RandomMovingStrategy)

    ResultView.printResultTitle()
    gameHost.start()
}
