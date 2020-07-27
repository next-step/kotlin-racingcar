package racingcar

import racingcar.strategy.RandomMovingStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carCount = InputView.readCarCount { InputValidator.isValidCarCount(it) }
    val tryCount = InputView.readTryCount { InputValidator.isValidTryCount(it) }
    val gameManager = RacingGame(carCount, tryCount, RandomMovingStrategy)

    ResultView.printResultTitle()
    gameManager.execute()
}
