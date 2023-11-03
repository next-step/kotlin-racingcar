package racingcar.controller

import racingcar.model.Games
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingController {
    fun start() {
        val racingGame = Games.from(InputView.inputCarList())
        val gameCount = InputView.inputGameCount()

        ResultView.printHeader()
        repeat(gameCount) {
            racingGame.play()
            ResultView.showProgress(racingGame.result())
        }
        ResultView.showWinner(racingGame.getWinner())
    }
}
