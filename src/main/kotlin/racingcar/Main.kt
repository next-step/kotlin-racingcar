package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val driverNames = InputView.getPlayerName()
    val tryCount = InputView.getTryCount()

    val game = RacingGame(driverNames, tryCount)

    game.start()

    ResultView.printResult(tryCount, game.drivers)
}
