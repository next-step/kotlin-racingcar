package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val driverNames = InputView.getPlayerName()
    val tryCount = InputView.getTryCount()
    val drivers = driverNames.map { Driver(it, Car()) }

    val game = RacingGame(drivers, tryCount)

    game.start()

    ResultView.printResult(game)
}
