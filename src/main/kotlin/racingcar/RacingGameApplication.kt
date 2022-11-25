package racingcar

import racingcar.service.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

object RacingGameApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        val carNames = InputView.readCarNames()
        val tryCount = InputView.readTryCount()

        val racingGame = RacingGame.of(carNames)

        ResultView.printHeader()
        repeat(tryCount) {
            racingGame.play()
            ResultView.printDashboard(racingGame)
        }
        ResultView.printWinners(racingGame)
    }
}
