package racingcar

import racingcar.service.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

object RacingGameApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        val carCount = InputView.readCarCount()
        val tryCount = InputView.readTryCount()

        val racingGame = RacingGame(carCount)

        ResultView.printHeader()
        repeat(tryCount) {
            racingGame.play()
            ResultView.printDashBoard(racingGame)
        }
    }
}
