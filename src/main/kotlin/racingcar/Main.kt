package racingcar

import racingcar.View.InputView
import racingcar.View.ResultView

fun main() {
    val carCount = InputView.getCarCount()
    val tryCount = InputView.getTryCount()

    val game = RacingGame(carCount, tryCount)

    game.start()

    ResultView.printResult(tryCount, game.driverList)
}
